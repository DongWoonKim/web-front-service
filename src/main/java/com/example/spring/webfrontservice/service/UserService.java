package com.example.spring.webfrontservice.service;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.JoinResponseDTO;
import com.example.spring.webfrontservice.dto.LoginRequestDTO;
import com.example.spring.webfrontservice.dto.LoginResponseDTO;
import com.example.spring.webfrontservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthClient authClient;

    public JoinResponseDTO join(JoinRequestDTO joinRequestDTO) {
        return authClient.join(joinRequestDTO);
    }

    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        return authClient.login(requestDTO);
    }
}
