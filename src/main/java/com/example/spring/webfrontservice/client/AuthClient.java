package com.example.spring.webfrontservice.client;

import com.example.spring.webfrontservice.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${polar.auth-service-uri}")
public interface AuthClient {

    @PostMapping("/auths/join")
    JoinClientResponseDTO join(@RequestBody JoinRequestDTO joinRequestDTO);

    @PostMapping("/auths/login")
    LoginClientResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO);

    @PostMapping("/auths/refresh")
    RefreshTokenClientResponseDTO refresh(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO);

    @PostMapping("/auths/validToken")
    ValidTokenResponseDTO validToken(@RequestBody ValidTokenRequestDTO validTokenRequestDTO);

    @PostMapping("/auths/claims")
    ClaimsResponseDTO getAuthentication(@RequestBody ClaimsReqeustDTO claimsReqeustDTO);
}
