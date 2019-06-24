package com.tomson.microserviceb.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class MicroserviceAFeignClientFallback implements MicroserviceAFeignClient {

    @Override
    public Optional<GetUserResponseDto> getUser(Long id) {
        log.info("blad wywolania getUser o id: {}", id);
        return Optional.empty();
    }
}
