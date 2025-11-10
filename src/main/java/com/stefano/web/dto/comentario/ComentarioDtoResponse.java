package com.stefano.web.dto.comentario;

import java.time.LocalDateTime;

public record ComentarioDtoResponse (
        String username,
        String contenido,
        LocalDateTime fechaPublicacion
){
}
