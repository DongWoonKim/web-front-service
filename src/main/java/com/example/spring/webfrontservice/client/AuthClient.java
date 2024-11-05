package com.example.spring.webfrontservice.client;

import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.JoinResponseDTO;
import com.example.spring.webfrontservice.dto.LoginRequestDTO;
import com.example.spring.webfrontservice.dto.LoginResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${polar.auth-service-uri}")
public interface AuthClient {

    @PostMapping("/auths/join")
    JoinResponseDTO join(@RequestBody JoinRequestDTO joinRequestDTO);

    @PostMapping("/auths/login")
    LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO);

}
