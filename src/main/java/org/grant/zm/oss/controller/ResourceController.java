package org.grant.zm.oss.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.BasicAuthDefinition;
import io.vavr.API;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.grant.zm.oss.base.Result;
import org.grant.zm.oss.base.ResultBuilder;
import org.grant.zm.oss.service.OssService;
import org.grant.zm.oss.store.FileInfos;
import org.grant.zm.oss.utils.ContentTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 */
@Slf4j
@RestController
@RequestMapping("/resource")
@Api("resource-api")
public class ResourceController extends BaseController{

    @Autowired
    OssService ossService;

    @PutMapping("/put")
    @ApiOperation("上传文件")
    @BasicAuthDefinition(key = "access", description = "用户凭证")
    public Result put(@RequestParam("file") MultipartFile multipartFile, @NotNull @RequestHeader("access") String access){
        FileInfos fileInfos = ossService.putFile(access, multipartFile);
        if (fileInfos == null) {
            return ResultBuilder.fail("文件上传失败");
        }
        return ResultBuilder.ok().body(fileInfos.getFileId());
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除文件")
    @BasicAuthDefinition(key = "access", description = "用户凭证")
    public Result delete(@NotEmpty @RequestParam("fileId") String fileId, @NotNull @RequestHeader("access") String access){
        return ossService.deleteFile(access, fileId) ? ResultBuilder.ok() : ResultBuilder.fail();
    }

    @GetMapping("/get/{fileId}")
    @ApiOperation("获取文件")
    public void getFile(@PathVariable("fileId") String fileId, HttpServletResponse response){
        InputStream fin = null;
        try {
            fin = ossService.getFile(fileId);
            if (fin == null) {
                notFound(response);
                return;
            }
            response.setContentType(ContentTypeUtils.getContentType(fileId.substring(fileId.lastIndexOf(".") + 1)));
            response.setHeader("Content-Disposition", "attachment;fileName="+fileId);
            IOUtils.copy(fin, response.getOutputStream());
        }catch (IOException e){
            log.error("文件下载失败", e);
            notFound(response);
        }finally {
            if (fin != null) IOUtils.closeQuietly(fin);
        }
    }

    @GetMapping("/preview")
    @ApiOperation("预览文件")
    public void previewFile(String fileId){
        API.TODO("待开发");
    }

    protected void notFound(HttpServletResponse response) {
        response.setContentType("text/plain; charset=utf-8");
        try {
            response.getWriter().println("找不到文件");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
