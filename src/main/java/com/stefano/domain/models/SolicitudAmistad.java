package com.stefano.domain.models;

import com.stefano.domain.models.enums.EstadoSolicitudAmistad;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "solicitudes_amistad")
@Builder
public class SolicitudAmistad {
    @Id
    private String id;
    private String emisorId;
    private String receptorId;
    private LocalDateTime fechaEnvio;
    private EstadoSolicitudAmistad estado;
}
