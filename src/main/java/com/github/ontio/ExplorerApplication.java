package com.github.ontio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ExplorerApplication {

	private static final Logger logger = LoggerFactory.getLogger(ExplorerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExplorerApplication.class, args);
	}
}
