package com.ogrenciyonetim.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.ogrenciyonetim"})
@EntityScan(basePackages = {"com.ogrenciyonetim"})
@EnableJpaRepositories(basePackages = {"com.ogrenciyonetim"})
@SpringBootApplication
public class OysApplication {

	public static void main(String[] args) {
		SpringApplication.run(OysApplication.class, args);
	}

}
