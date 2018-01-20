package com.github;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.legal.mapper")
public class HeLegalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeLegalApplication.class, args);
	}
}
