package com.stefano.application.services.Impl;

import com.stefano.application.exception.ErrorNegocio;
import com.stefano.application.security.JwtService;
import com.stefano.application.services.AuthService;
import com.stefano.domain.models.Usuario;
import com.stefano.domain.repository.UsuarioRepository;
import com.stefano.web.dto.usuario.AuthRequest;
import com.stefano.web.dto.usuario.AuthResponse;
import com.stefano.web.dto.usuario.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new ErrorNegocio("El nombre de usuario ya está en uso.",HttpStatus.CONFLICT);
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new ErrorNegocio("El email ya está en uso.",HttpStatus.CONFLICT);
        }

        Usuario user = new Usuario();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFechaNacimiento(request.getFechaNacimiento());
        user.setPasswordHash(bCryptPasswordEncoder.encode(request.getPassword()));

        usuarioRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Usuario user = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ErrorNegocio("Usuario no encontrado.", HttpStatus.NOT_FOUND));

        if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new ErrorNegocio("Contraseña incorrecta.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
