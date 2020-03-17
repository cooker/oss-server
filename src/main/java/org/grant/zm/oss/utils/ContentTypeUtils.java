package org.grant.zm.oss.utils;

import org.grant.zm.utils.GStringUtils;

/**
 * ZoomGrant 2020/3/11 12:21
 */
public class ContentTypeUtils {
    public static String getContentType(String suffix){
        String tSuffix = "";
        switch (suffix.toLowerCase()) {
            case "png":
            case "gif":
                tSuffix = "image/" + suffix.toLowerCase();
                break;
            case "jpg":
            case "jpeg":
                tSuffix = "image/jpeg";
                break;
            case "mp4":
                tSuffix = "video/mpeg4";
                break;
            default:
                tSuffix = "multipart/form-data";
                break;
        }

        return tSuffix;
    }
}
