package com.stefano.web.controller;

import com.stefano.application.services.PublicacionService;
import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PublicacionController {
    private final PublicacionService publicacionService;

    @PostMapping("/generar-publicacion")
    public ResponseEntity<PublicacionDtoResponse> crearPublicacion(
            @RequestBody PublicacionDtoRequest publicacionDtoRequest,
            Authentication authentication
    ){
        PublicacionDtoResponse dtoResponse = publicacionService.crearPublicacion(publicacionDtoRequest, authentication);
        return ResponseEntity.ok().body(dtoResponse);
    }
}
