package com.f00lish.xcloud.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class XcloudGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudGenerateApplication.class, args);
	}
}
