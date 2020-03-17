package org.grant.zm.oss.config;

import lombok.Data;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ZoomGrant 2020/3/10 15:38
 */
@Data
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:application-oss.yml")
@ConfigurationProperties(value = "oss")
public class OssConfig {
    private String winDir;
    private String linuxDir;

    public String getDir(){
        return SystemUtils.IS_OS_WINDOWS ? winDir : linuxDir;
    }
}
