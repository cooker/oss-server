package org.grant.zm.oss.service;

import org.grant.zm.oss.store.FileInfos;

public interface RedisService {
    void addFileId(FileInfos fileInfos);

    FileInfos getFileInfos(String fileId);

}
