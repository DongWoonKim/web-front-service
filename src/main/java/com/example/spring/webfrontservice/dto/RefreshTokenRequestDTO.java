package com.example.spring.webfrontservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RefreshTokenRequestDTO {

    private String refreshToken;

}
