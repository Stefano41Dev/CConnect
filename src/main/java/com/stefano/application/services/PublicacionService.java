package com.stefano.application.services;

import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PublicacionService {
    PublicacionDtoResponse crearPublicacion(PublicacionDtoRequest publicacionDtoRequest, Authentication authentications);
    List<PublicacionDtoResponse> listarPublicacionesUser(String username);

}
