package com.tomson.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class AuthorizationService {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationService.class, args);
    }

}