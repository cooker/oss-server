package org.grant.zm.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ZoomGrant 2020/3/10 15:38
 */
@Data
@Configuration
@ConfigurationProperties(value = "oss")
public class OssConfig {
    private String dir;
}
