package com.example.spring.webfrontservice.config.filter;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.ClaimsReqeustDTO;
import com.example.spring.webfrontservice.dto.ClaimsResponseDTO;
import com.example.spring.webfrontservice.dto.ValidTokenRequestDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final AuthClient authClient;
    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer ";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        log.info("requestURI: {}", requestURI);

        if (
                (
                        requestURI.startsWith("/webs")
                        && !requestURI.contains("/api/hello")
                )
                || requestURI.startsWith("/js")
                || requestURI.startsWith("/css")
                || requestURI.equals("/login")
                || requestURI.equals("/refresh-token")
        ) {
            chain.doFilter(request, response);
            return;
        }

        String token = resolveToken(request);
        log.info("token: {}", token);
        int statusNum = (token == null)
                ? -1
                : authClient.validToken(
                        ValidTokenRequestDTO.builder()
                                .token(token)
                                .build()
        ).getStatusNum();
        log.info("statusNum: {}", statusNum);
        if (statusNum == 1) {

            ClaimsResponseDTO claims = authClient.getAuthentication(
                    ClaimsReqeustDTO.builder()
                            .token(token)
                            .build()
            );

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            claims.getUserId(),     // principal (사용자 식별자)
                            null,                   // credentials (보통 비밀번호이나, 이미 인증된 경우 null)
                            claims.getRoles().stream()  // authorities (권한 목록)
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList())
                    )
            );

        } else if (statusNum == 2) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        chain.doFilter(request, response);

    }

    private String resolveToken(HttpServletRequest request) {
        // Authorization 헤더에서 JWT 토큰 추출
        String bearerToken = request.getHeader(HEADER_AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
