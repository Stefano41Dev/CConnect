package com.stefano.web.dto.solicitud;

public record CambiarEstadoSolicitudDtoRequest (
        String idSolicitudAmistad,
        String estadoSolicitud
){
}
