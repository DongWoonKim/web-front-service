package com.example.spring.webfrontservice.service;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthClient authClient;

    public String join(JoinRequestDTO joinRequestDTO) {
        return authClient.join(joinRequestDTO) ? "/webs/login" : "/webs/join";
    }

}
