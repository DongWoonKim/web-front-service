package com.example.spring.webfrontservice.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequestDTO {
    private String userId;
    private String password;
}
