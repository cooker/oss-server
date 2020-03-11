package org.grant.zm.oss.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ZoomGrant 2020/3/10 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Result<T> {
    int code;
    String message;
    T body;

    public Result body(T body){
        this.body = body;
        return this;
    }
}
