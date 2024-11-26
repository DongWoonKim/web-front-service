package com.example.spring.webfrontservice.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateCatalogRequestDTO {
    private String isbn;
    private String title;
    private String author;
    private Double price;
}
