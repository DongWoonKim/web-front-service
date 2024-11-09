package com.example.spring.webfrontservice.service;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.RefreshTokenClientResponseDTO;
import com.example.spring.webfrontservice.dto.RefreshTokenRequestDTO;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthClient authClient;

    public RefreshTokenClientResponseDTO refreshToken(Cookie[] cookies) {
        // 쿠키에서 Refresh Token을 추출
        String refreshToken = getRefreshTokenFromCookies(cookies);
        if (refreshToken == null) return null;

        RefreshTokenRequestDTO build = RefreshTokenRequestDTO.builder()
                .refreshToken(refreshToken)
                .build();

        System.out.println("refresh :: " + build);
        return authClient.refresh(build);
    }

    private String getRefreshTokenFromCookies(Cookie[] cookies) {
        // 요청에 쿠키가 있는지 확인
        if (cookies != null) {
            // 쿠키 배열에서 'refreshToken'이라는 이름의 쿠키를 찾아 반환
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("refreshToken")) {
                    return cookie.getValue(); // Refresh Token 값 반환
                }
            }
        }

        // 'refreshToken' 쿠키가 없으면 null 반환
        return null;
    }
}
