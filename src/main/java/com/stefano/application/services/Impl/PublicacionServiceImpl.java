package com.stefano.application.services.Impl;

import com.stefano.application.mapper.PublicacionMapper;
import com.stefano.application.services.PublicacionService;
import com.stefano.domain.models.Publicacion;
import com.stefano.domain.repository.PublicacionRepository;
import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicacionServiceImpl implements PublicacionService {
    private final PublicacionMapper publicacionMapper;
    private final PublicacionRepository publicacionRepository;
    @Override
    public PublicacionDtoResponse crearPublicacion(PublicacionDtoRequest publicacionDtoRequest, Authentication authentication) {
        Publicacion publicacion = publicacionMapper.toEntity(publicacionDtoRequest);
        publicacion.setId(null);
        return null;
    }

    @Override
    public List<PublicacionDtoResponse> listarPublicacionesUser(String username) {
        return List.of();
    }
}
