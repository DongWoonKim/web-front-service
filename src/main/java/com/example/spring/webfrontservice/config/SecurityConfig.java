package com.example.spring.webfrontservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)

                // URL 기반 권한 설정
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/webs/**",
                                "/refresh-token",
                                "/login",
                                "/logout",
                                "/access-denied"
                        )
                        .permitAll()
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
        ;

        return http.build();
    }


}
