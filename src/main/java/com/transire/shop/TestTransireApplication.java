package com.transire.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestTransireApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTransireApplication.class, args);
	}
}
