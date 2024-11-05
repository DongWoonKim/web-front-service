package com.example.spring.webfrontservice.dto;

import lombok.Getter;

@Getter
public class LoginClientResponseDTO {
    private boolean isLoggedIn;
    private String userName;
    private String userId;
    private String message;
    private String accessToken;
    private String refreshToken;

    public LoginResponseDTO toLoginResponseDTO() {
        return LoginResponseDTO.builder()
                .isLoggedIn(isLoggedIn)
                .userName(userName)
                .userId(userId)
                .message(message)
                .accessToken(accessToken)
                .build();
    }
}
