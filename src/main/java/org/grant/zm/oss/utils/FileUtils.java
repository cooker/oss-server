package org.grant.zm.oss.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ZoomGrant 2020/3/10 17:29
 */
public class FileUtils {

    public static String upload(MultipartFile file, String filePath) throws IOException {
        String fileId = randomFileId() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        OutputStream out = Files.newOutputStream(Paths.get(filePath, fileId));
        IOUtils.copy(file.getInputStream(), out);
        out.close();
        return fileId;
    }

    public static String randomFileId(){
        return RandomStringUtils.random(128, true, true);
    }
}
