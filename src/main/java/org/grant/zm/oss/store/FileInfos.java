package org.grant.zm.oss.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ZoomGrant 2020/3/11 10:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfos {
    private String fileId;
    private String access;
}
