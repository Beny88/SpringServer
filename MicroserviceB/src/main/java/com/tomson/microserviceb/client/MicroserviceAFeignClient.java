package com.tomson.microserviceb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@FeignClient(name = "Microservice-A", fallback = MicroserviceAFeignClientFallback.class)
public interface MicroserviceAFeignClient {

    @RequestMapping(value = "/user/{id}")
    Optional<GetUserResponseDto> getUser(@PathVariable("id") Long id);
}
