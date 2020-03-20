package org.grant.zm.oss.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.grant.zm.oss.base.Result;
import org.grant.zm.oss.base.ResultBuilder;
import org.grant.zm.oss.service.OssService;
import org.grant.zm.oss.store.AccountInfo;
import org.grant.zm.oss.utils.AccountUtils;
import org.grant.zm.spring2.annotation.GLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
/**
 * 账户接口
 */
@Slf4j
@RestController
@RequestMapping("account")
@Api("account-api")
public class AccountController extends BaseController {

    @Autowired
    OssService ossService;

    @GetMapping("/create")
    @ApiOperation("创建用户")
    @GLog(value = "创建用户")
    public Result create(@Validated AccountInfo accountInfo, BindingResult result) {
        if (result.hasErrors()){
            return failValidate(result);
        }
        String str = AccountUtils.randomAccess();
        try {
            ossService.createAccountDir(str, accountInfo);
        } catch (IOException e) {
            ResultBuilder.fail("目录创建失败");
        }
        return ResultBuilder.ok().body(str);
    }

    @GetMapping("/edit")
    @ApiOperation("编辑用户")
    @GLog(value = "编辑用户")
    @BasicAuthDefinition(key = "access", description = "用户凭证")
    public Result edit(@Validated AccountInfo accountInfo, @NotEmpty @RequestHeader("access") String access, BindingResult result) {
        if (result.hasErrors()){
            return failValidate(result);
        }
        try {
            boolean isT = ossService.editAccountInfo(access, accountInfo);
            if (!isT) return ResultBuilder.fail("用户信息修改失败");
        } catch (IOException e) {
            ResultBuilder.fail("用户信息修改失败");
        }
        return ResultBuilder.ok();
    }
}
