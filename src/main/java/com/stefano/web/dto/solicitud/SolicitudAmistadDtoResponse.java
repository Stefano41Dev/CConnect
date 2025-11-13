package com.stefano.web.dto.solicitud;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record SolicitudAmistadDtoResponse(
    String id,
    String emisorId,
    String receptorId,
    LocalDateTime fechaEnvio,
    String estado
){

}
