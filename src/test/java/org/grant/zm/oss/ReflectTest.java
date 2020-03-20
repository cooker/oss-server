package org.grant.zm.oss;

import org.grant.zm.oss.controller.ResourceController;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * grant
 * 20/3/2020 12:29 下午
 * 描述：
 */
public class ReflectTest {
    @Test
    public void look(){
       Method method = ReflectionUtils.findMethod(ResourceController.class, "getFile", getClassx());
        System.out.println(method);
    }

    private Class[] getClassx(){
        return  new Class[]{
                String.class,
                HttpServletResponse.class
        };
    }
}
