package org.grant.zm.oss.base;

/**
 * ZoomGrant 2020/3/10 16:07
 */
public class ResultBuilder {

    public static Result ok(){
        Result result = build();
        result.setCode(Contansts.success);
        result.setMessage("success");
        return result;
    }


    public static Result fail(){
        Result result = build();
        result.setCode(Contansts.fail);
        result.setMessage("fail");
        return result;
    }

    public static Result fail(String errMsg){
        Result result = build();
        result.setCode(Contansts.fail);
        result.setMessage(errMsg);
        return result;
    }

    public static Result auth_fail(){
        Result result = build();
        result.setCode(Contansts.auth_fail);
        result.setMessage("认证失败");
        return result;
    }

    public static Result build(){
        return new Result();
    }
}
