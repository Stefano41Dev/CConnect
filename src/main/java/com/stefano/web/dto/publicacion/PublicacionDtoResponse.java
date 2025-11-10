package com.stefano.web.dto.publicacion;

import com.stefano.web.dto.comentario.ComentarioDtoResponse;

import java.time.LocalDateTime;
import java.util.List;

public record PublicacionDtoResponse (
        String usernameAutor,
        String contenido,
        LocalDateTime fechaPublicacion,
        List<ComentarioDtoResponse> comentarios
){
}
