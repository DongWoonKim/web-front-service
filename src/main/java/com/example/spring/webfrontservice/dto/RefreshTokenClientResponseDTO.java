package com.example.spring.webfrontservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshTokenClientResponseDTO {
    private int status;
    private String accessToken;
    private String refreshToken;

    public RefreshTokenRequestDTO toRefreshTokenRequestDTO() {
        return RefreshTokenRequestDTO.builder()
                .build();
    }
}
