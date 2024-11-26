package com.example.spring.webfrontservice.exception;

import com.example.spring.webfrontservice.dto.ErrorResponseDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorized(FeignException ex) {
        // FeignException에서 상태 코드 추출
        int statusCode = ex.status();

        // 에러 메시지 처리
        String message = ex.getMessage();

        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .statusCode(statusCode) // 동적으로 상태 코드 설정
                .message(message != null ? message : "Unknown error occurred")
                .build();

        // 동적으로 상태 코드 반환
        return ResponseEntity.status(statusCode).body(response);
    }
}
