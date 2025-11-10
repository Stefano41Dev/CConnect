package com.stefano.application.mapper;

import com.stefano.domain.models.Publicacion;
import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PublicacionMapper {
    private final ComentarioMapper comentarioMapper;
    public Publicacion toEntity (PublicacionDtoRequest publicacionDtoRequest) {
        return Publicacion.builder()
                .contenido(publicacionDtoRequest.contenido())
                .fechaPublicacion(LocalDateTime.now())
                .build();
    }
    public PublicacionDtoResponse toDto (Publicacion publicacion) {
        return PublicacionDtoResponse.builder()
                //.usernameAutor(publicacion.getId())
                .contenido(publicacion.getContenido())
                .fechaPublicacion(publicacion.getFechaPublicacion())
                .comentarios(publicacion.getComentarios().stream().map(comentarioMapper::toDto).toList())
                .build();

    }
}
