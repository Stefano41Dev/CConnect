package com.stefano.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String username;
    private String email;
    private LocalDate fechaNacimiento;
    private String passwordHash;
    private List<String> amigosIds;

}
