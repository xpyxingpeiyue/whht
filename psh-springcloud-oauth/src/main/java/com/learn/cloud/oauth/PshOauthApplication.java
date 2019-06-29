package com.learn.cloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by peiyue.xing on 2019/6/28 18:52
 *
 * @version: 0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class PshOauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(PshOauthApplication.class, args);
    }
}
