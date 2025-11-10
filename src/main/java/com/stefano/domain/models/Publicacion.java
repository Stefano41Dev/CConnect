package com.stefano.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "publicacion")
@Data
public class Publicacion {
    @Id
    private String id;
    private String userid;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;
    private List<String> imagenesUrl;
}
