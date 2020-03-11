package org.grant.zm.oss.service;

import org.grant.zm.oss.store.AccountInfo;
import org.grant.zm.oss.store.FileInfos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * ZoomGrant 2020/3/10 17:03
 */
public interface OssService {
    void createAccountDir(String access, AccountInfo accountInfo) throws IOException;
    boolean editAccountInfo(String access, AccountInfo accountInfo) throws IOException;
    FileInfos putFile(String access, MultipartFile multipartFile);
    boolean deleteFile(String access, String fileId);

    InputStream getFile(String fileId);
}
