package org.grant.zm.oss.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.grant.zm.oss.base.StoreType;
import org.grant.zm.oss.config.OssConfig;
import org.grant.zm.oss.service.OssService;
import org.grant.zm.oss.service.RedisService;
import org.grant.zm.oss.store.AccountInfo;
import org.grant.zm.oss.store.FileInfos;
import org.grant.zm.oss.utils.AccountUtils;
import org.grant.zm.oss.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ZoomGrant 2020/3/10 17:03
 */
@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    OssConfig ossConfig;
    @Autowired
    RedisService redisService;

    @Override
    public void createAccountDir(String access, AccountInfo accountInfo) throws IOException {
        Path path = Paths.get(ossConfig.getDir(), access);
        path.toFile().mkdirs();
        AccountUtils.wirteAccountInfo(path.toString(), accountInfo);
    }

    @Override
    public boolean isAccount(String access) {
        Path path = Paths.get(ossConfig.getDir(), access);
        return path.toFile().exists();
    }

    @Override
    public boolean editAccountInfo(String access, AccountInfo accountInfo) throws IOException {
        Path path = Paths.get(ossConfig.getDir(), access);
        if (isAccount(access)){
            AccountUtils.wirteAccountInfo(path.toString(), accountInfo);
        }
        return path.toFile().exists();
    }

    @Override
    public FileInfos putFile(String access, MultipartFile multipartFile) {
        FileInfos fileInfos = null;
        try {
            String fileId = FileUtils.upload(multipartFile,  Paths.get(ossConfig.getDir(), access).toString());
            fileInfos = new FileInfos(fileId, access, StoreType.LOCAL);
            redisService.addFileId(fileInfos);
        } catch (IOException e) {
            log.error("文件上传失败 access={}", access);
            return null;
        }
        return fileInfos;
    }

    @Override
    public boolean deleteFile(String access, String fileId) {
        try{
            return Files.deleteIfExists(Paths.get(ossConfig.getDir(), access, fileId));
        }catch (IOException e) {
            log.error("文件删除失败 access={} fileId={}", access, fileId);
        }
        return false;
    }

    @Override
    public InputStream getFile(String fileId) {
        FileInfos fileInfos = redisService.getFileInfos(fileId);
        if (fileInfos == null) return null;
        try {
            if (StoreType.LOCAL.equals(fileInfos.getStoreType())) {
                return Files.newInputStream(Paths.get(ossConfig.getDir(), fileInfos.getAccess() , fileId));
            }else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}