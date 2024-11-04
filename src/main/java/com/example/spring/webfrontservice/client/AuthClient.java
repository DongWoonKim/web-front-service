package com.example.spring.webfrontservice.client;

import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${polar.auth-service-uri}")
public interface AuthClient {
    @PostMapping("/auths/join")
    boolean join(@RequestBody JoinRequestDTO joinRequestDTO);
}