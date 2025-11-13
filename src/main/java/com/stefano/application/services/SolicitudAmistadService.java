package com.stefano.application.services;

import com.stefano.web.dto.solicitud.CambiarEstadoSolicitudDtoRequest;
import com.stefano.web.dto.solicitud.MandarSolicitudAmistadDtoRequest;
import com.stefano.web.dto.solicitud.SolicitudAmistadDtoResponse;

public interface SolicitudAmistadService {
    SolicitudAmistadDtoResponse mandarSolicitudAmistad(MandarSolicitudAmistadDtoRequest request);
    void cambiarEstadoSolicitudAmistad(CambiarEstadoSolicitudDtoRequest request);

}
