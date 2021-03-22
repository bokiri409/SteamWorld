package com.a105.apiServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//0322 test
@SpringBootApplication
public class A105Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(A105Application.class, args);
	}

}
