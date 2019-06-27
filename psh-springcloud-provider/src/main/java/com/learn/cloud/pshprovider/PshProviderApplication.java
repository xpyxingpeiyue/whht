package com.learn.cloud.pshprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PshProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PshProviderApplication.class, args);
	}

}
