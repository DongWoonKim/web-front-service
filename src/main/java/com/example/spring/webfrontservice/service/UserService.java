package com.example.spring.webfrontservice.service;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.JoinResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthClient authClient;

    public JoinResponseDTO join(JoinRequestDTO joinRequestDTO) {
        return authClient.join(joinRequestDTO);
    }

}
