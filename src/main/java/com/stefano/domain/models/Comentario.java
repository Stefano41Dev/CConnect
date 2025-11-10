package com.stefano.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "comentarios")
@Data
public class Comentario {
    @Id
    private String id;
    private String userid;
    private String contenido;
    private LocalDateTime fechaPublicacion;
}
