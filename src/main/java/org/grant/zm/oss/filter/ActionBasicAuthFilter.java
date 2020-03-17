package org.grant.zm.oss.filter;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.grant.zm.oss.base.ResultBuilder;
import org.grant.zm.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * grant
 * 17/3/2020 11:44 上午
 * 描述：
 */
@Component
@Aspect
public class ActionBasicAuthFilter {

    @Autowired
    OssService ossService;

    @Around("@annotation(io.swagger.annotations.BasicAuthDefinition)")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        String access  = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest().getHeader("access");
        if (StringUtils.isBlank(access)) {
            return ResultBuilder.auth_fail();
        }else {
            if (ossService.isAccount(access)) {
                return joinPoint.proceed();
            }else {
                return ResultBuilder.auth_fail();
            }
        }
    }
}
