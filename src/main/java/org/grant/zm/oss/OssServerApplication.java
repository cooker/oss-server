package org.grant.zm.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class OssServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssServerApplication.class, args);
    }

}
