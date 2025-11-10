package com.stefano.application.services;

import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;

import java.util.List;

public interface PublicacionService {
    PublicacionDtoResponse crearPublicacion(PublicacionDtoRequest publicacionDtoRequest);
    List<PublicacionDtoResponse> listarPublicacionesUser(String username);

}
