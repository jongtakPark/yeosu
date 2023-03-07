package com.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ExpositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpositionApplication.class, args);
	}

}
