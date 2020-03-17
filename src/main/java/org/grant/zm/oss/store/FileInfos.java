package org.grant.zm.oss.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grant.zm.oss.base.StoreType;

/**
 * ZoomGrant 2020/3/11 10:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileInfos {
    private String fileId;
    private String access;
    private StoreType storeType;

}
