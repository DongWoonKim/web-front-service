package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.CreateCatalogRequestDTO;
import com.example.spring.webfrontservice.dto.CreateCatalogResponseDTO;
import com.example.spring.webfrontservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/webs/api")
public class HomeApiController {

    private final CatalogService catalogService;

    @PostMapping("/catalog")
    public CreateCatalogResponseDTO createCatalog(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @RequestBody CreateCatalogRequestDTO createCatalogRequestDTO
    ) {
        return catalogService.createCatalog(authorizationHeader, createCatalogRequestDTO);
    }

}
