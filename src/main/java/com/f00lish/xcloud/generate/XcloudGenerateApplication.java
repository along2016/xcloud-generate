package com.f00lish.xcloud.generate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.f00lish.xcloud.generate.mapper")
public class XcloudGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudGenerateApplication.class, args);
	}

}
