package com.stefano.web.dto.publicacion;

import com.stefano.web.dto.comentario.ComentarioDtoResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
@Builder
public record PublicacionDtoResponse (
        String usernameAutor,
        String contenido,
        LocalDateTime fechaPublicacion,
        List<ComentarioDtoResponse> comentarios
){
}
