package com.learn.cloud.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PshCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PshCrawlerApplication.class, args);
	}

}
