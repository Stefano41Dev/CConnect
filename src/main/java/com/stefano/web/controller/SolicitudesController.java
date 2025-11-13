package com.stefano.web.controller;

import com.stefano.application.services.SolicitudAmistadService;
import com.stefano.web.dto.solicitud.CambiarEstadoSolicitudDtoRequest;
import com.stefano.web.dto.solicitud.MandarSolicitudAmistadDtoRequest;
import com.stefano.web.dto.solicitud.SolicitudAmistadDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudesController {
    private final SolicitudAmistadService solicitudAmistadService;
    @PostMapping("/mandar-solicitud")
    public ResponseEntity<SolicitudAmistadDtoResponse> mandarSolicitudAmistad(
            @RequestBody MandarSolicitudAmistadDtoRequest request
    ){
       SolicitudAmistadDtoResponse dtoResponse =  solicitudAmistadService.mandarSolicitudAmistad(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

    @PostMapping("/cambiar-estado")
    public ResponseEntity<SolicitudAmistadDtoResponse> cambiarEstadoSolicitudAmistad (
            @RequestBody CambiarEstadoSolicitudDtoRequest request
    ){
       solicitudAmistadService.cambiarEstadoSolicitudAmistad(request);
       return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
