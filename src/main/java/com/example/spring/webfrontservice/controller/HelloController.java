package com.example.spring.webfrontservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/webs")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/api/hello")
    @ResponseBody
    public HelloResponseDTO helloPost(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @RequestBody HelloRequestDTO requestDTO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        System.out.println("authorizationHeader :: " + authorizationHeader);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // principal(subject/userId) 가져오기
//        String userId = authentication.getName();  // 또는 authentication.getPrincipal().toString()

        // roles/authorities 가져오기
//        List<String> roles = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .toList();

        return HelloResponseDTO.builder()
                .message("It's ok.")
                .build();
    }

    @Getter
    @ToString
    static class HelloRequestDTO {
        String message;
    }

    @Getter
    @Builder
    @ToString
    static class HelloResponseDTO {
        String message;
    }

}
