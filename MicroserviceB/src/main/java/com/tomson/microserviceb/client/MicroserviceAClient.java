package com.tomson.microserviceb.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MicroserviceAClient {

    private static final String MICROSERVICE_A_URL = "http://localhost:8090";
    private static final String MICROSERVICE_A_USER_URL = "user";

    private MicroserviceAFeignClient microserviceAFeignClient;

    public MicroserviceAClient(MicroserviceAFeignClient microserviceAFeignClient) {
        this.microserviceAFeignClient = microserviceAFeignClient;
    }

    public void getUserViaFeignClient(final Long userId) {
        microserviceAFeignClient.getUser(userId).ifPresent(response -> log.info(response.toString()));
    }

    //REST Template Conection Serv to Serv Without List of Servers from Eureka
    public void getUser(final Long userId) {
        RestTemplate restTemplate = new RestTemplate();

        String getUserUrl = String.format("%s/%s/%s", MICROSERVICE_A_URL, MICROSERVICE_A_USER_URL, userId);

        ResponseEntity<GetUserResponseDto> response = restTemplate.getForEntity(getUserUrl, GetUserResponseDto.class);
        HttpStatus status = response.getStatusCode();
        log.info("Otrzymalem odpowiedz z url {} status: {}", getUserUrl, status);

        if(status == HttpStatus.OK) {
            GetUserResponseDto getUserResponseDto = response.getBody();
            log.info(getUserResponseDto.toString());
        }
    }

    public void getUsers(final Long userId) {
        RestTemplate restTemplate = new RestTemplate();

        String getUserUrl = String.format("%s/%s", MICROSERVICE_A_URL, MICROSERVICE_A_USER_URL);

        ResponseEntity<GetUserResponseDto> response = restTemplate.getForEntity(getUserUrl, GetUserResponseDto.class);
    }
}
