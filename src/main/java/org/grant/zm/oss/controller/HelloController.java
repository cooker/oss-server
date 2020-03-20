package org.grant.zm.oss.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.grant.zm.spring2.extend.GRestHelper;
import org.grant.zm.spring2.extend.GSpringWebHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * grant
 * 20/3/2020 3:57 下午
 * 描述：
 */
@Slf4j
@RestController
@RequestMapping("test")
public class HelloController extends BaseController {

    @Autowired
    GRestHelper gRestHelper;


    @RequestMapping("/")
    public String ok(@RequestParam("hello") String hello,
                     @RequestHeader(value = "gt-time", defaultValue = "") String gtTime,
                     @RequestBody(required = false) String body) throws IOException {
        String headers = GSpringWebHelper.getRequestHeadersByJson(GSpringWebHelper.getRequest());
        String params = GSpringWebHelper.getRequestParamsByJson(GSpringWebHelper.getRequest());

        log.info("请求来了：\n{}\n{}\n{}", headers, params, body);

        if (StringUtils.isEmpty(gtTime)){
             Response response = gRestHelper.relayRequest("http://www.baidu.com", 80, GSpringWebHelper.getRequest());
             log.info("转发状态：{} >> {}", response.code(), response.body().string());
        }
        return "aaa";
    }

    @RequestMapping("/test")
    public String ok(@RequestBody(required = false) String body) throws IOException {
        String headers = GSpringWebHelper.getRequestHeadersByJson(GSpringWebHelper.getRequest());
        String params = GSpringWebHelper.getRequestParamsByJson(GSpringWebHelper.getRequest());

        log.info("请求来了：\n{}\n{}\n{}", headers, params, body);

        return "aaa";
    }
}
