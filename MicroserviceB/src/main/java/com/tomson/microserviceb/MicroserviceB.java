package com.tomson.microserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MicroserviceB {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceB.class);
    }
}
