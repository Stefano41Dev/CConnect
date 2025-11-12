package com.stefano.application.services.Impl;

import com.stefano.application.exception.ErrorNegocio;
import com.stefano.application.mapper.PublicacionMapper;
import com.stefano.application.services.PublicacionService;
import com.stefano.domain.models.Publicacion;
import com.stefano.domain.models.Usuario;
import com.stefano.domain.repository.PublicacionRepository;
import com.stefano.domain.repository.UsuarioRepository;
import com.stefano.web.dto.publicacion.PublicacionDtoRequest;
import com.stefano.web.dto.publicacion.PublicacionDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicacionServiceImpl implements PublicacionService {
    private final PublicacionMapper publicacionMapper;
    private final PublicacionRepository publicacionRepository;
    private final UsuarioRepository usuarioRepository;
    @Override
    public PublicacionDtoResponse crearPublicacion(PublicacionDtoRequest publicacionDtoRequest, Authentication authentication) {

        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ErrorNegocio("Usuario no encontrado", HttpStatus.NOT_FOUND));
        Publicacion publicacion = publicacionMapper.toEntity(publicacionDtoRequest);

        publicacion.setUserid(usuario.getId());
        publicacion.setFechaPublicacion(LocalDateTime.now());
        publicacion.setComentarios(List.of());

        publicacion = publicacionRepository.save(publicacion);
        PublicacionDtoResponse dtoResponse = publicacionMapper.toDto(publicacion);
        dtoResponse.setUsernameAutor(username);
        return dtoResponse;
    }

    @Override
    public List<PublicacionDtoResponse> listarPublicacionesUser(String username) {
        return List.of();
    }
}
