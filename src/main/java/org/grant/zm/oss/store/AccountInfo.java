package org.grant.zm.oss.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ZoomGrant 2020/3/10 15:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    /**
     * 作者
     */
    @NotEmpty
    @Size(max = 128, message = "最大长度128")
    private String author;
    /**
     * 作者网站
     */
    @NotEmpty
    @Size(max = 512, message = "最大长度512")
    private String authorUrl;
}
