package com.tomson.microserviceb.client;

import lombok.Data;

@Data
public class GetUserResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
