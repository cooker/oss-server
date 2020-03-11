package org.grant.zm.oss.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.grant.zm.oss.store.AccountInfo;
import org.grant.zm.utils.GJsonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

/**
 * ZoomGrant 2020/3/10 16:56
 * 账户工具类
 */
public class AccountUtils {

    public static String randomAccess(){
        char[] access = RandomStringUtils.random(32, true, true).toCharArray();

        return IntStream.range(1, 32).collect(StringBuilder::new, (sb, i)->{
            if (i % 4 == 0) {
                sb.append("-");
            }
            sb.append(access[i-1]);
        }, (a, b)->{}).toString();
    }

    public static void wirteAccountInfo(String filePath, AccountInfo accountInfo) throws IOException {
        OutputStream fout = Files.newOutputStream(Paths.get(filePath, "account.json"), StandardOpenOption.WRITE);
        IOUtils.write(GJsonUtils.toJson(accountInfo), fout, "utf-8");
        fout.close();
    }

    public static AccountInfo readAccountInfo(String filePath) throws IOException {
        InputStream fin = Files.newInputStream(Paths.get(filePath));
        String json = IOUtils.toString(fin, "utf-8");
        fin.close();
        return GJsonUtils.toBean(json, AccountInfo.class);
    }
}
