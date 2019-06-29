package com.learn.cloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by peiyue.xing on 2019/6/28 18:52
 *
 * @version: 0.1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer //开启资源服务，因为程序需要对外暴露获取token的API接口
public class PshOauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(PshOauthApplication.class, args);
    }
}
