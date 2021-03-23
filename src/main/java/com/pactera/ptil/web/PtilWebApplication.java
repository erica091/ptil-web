package com.pactera.ptil.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pactera.ptil.web.mapper")
public class PtilWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtilWebApplication.class, args);
	}
}
