package com.example.spring.webfrontservice.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ClaimsResponseDTO {
    private String userId;
    private List<String> roles;
}
