package com.tomson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
//i tu adnotacje jedno taka cpos o audtiing :D
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}
}
