package org.grant.zm.oss.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ZoomGrant 2020/3/10 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceInfo {
    /**
     * 文件ID
     */
    private String fid;
    /**
     * 文件名
     */
    private String fName;
    private String type;
    private String url;
}
