package com.example.spring.webfrontservice.dto;

import lombok.Getter;

@Getter
public class LoginResponseDTO {
    private boolean isLoggedIn;
    private String url;
    private String userName;
    private String userId;
    private String message;
    private String accessToken;
    private String refreshToken;
}
