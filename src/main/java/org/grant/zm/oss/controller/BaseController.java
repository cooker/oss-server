package org.grant.zm.oss.controller;


import org.grant.zm.oss.base.Result;
import org.grant.zm.oss.base.ResultBuilder;
import org.grant.zm.utils.GStringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public abstract class BaseController {

    protected Result failValidate(BindingResult result) {
        StringBuilder sb = GStringUtils.newBuilder();
        for (FieldError fieldError : result.getFieldErrors()) {
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage());
            sb.append(",");
        }

        return ResultBuilder.fail(sb.toString());
    }
}
