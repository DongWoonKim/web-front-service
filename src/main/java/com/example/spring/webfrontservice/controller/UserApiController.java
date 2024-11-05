package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.JoinResponseDTO;
import com.example.spring.webfrontservice.dto.LoginRequestDTO;
import com.example.spring.webfrontservice.dto.LoginResponseDTO;
import com.example.spring.webfrontservice.service.UserService;
import com.example.spring.webfrontservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDTO> join(@RequestBody JoinRequestDTO joinRequestDTO) {
        return ResponseEntity.ok( userService.join(joinRequestDTO) );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> signIn(
            @RequestBody LoginRequestDTO requestDTO,
            HttpServletResponse response
    ) {
        LoginResponseDTO logined = userService.login(requestDTO);
        // Refresh Token을 HttpOnly 쿠키에 저장
        CookieUtil.addCookie(response, "refreshToken", logined.getRefreshToken(), 7 * 24 * 60 * 60);

        return ResponseEntity.ok( logined );
    }

}
