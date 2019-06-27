package com.learn.cloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PshConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PshConsumerRibbonApplication.class, args);
	}

}
