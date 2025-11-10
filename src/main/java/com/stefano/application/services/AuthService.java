package com.stefano.application.services;

import com.stefano.web.dto.usuario.AuthRequest;
import com.stefano.web.dto.usuario.AuthResponse;
import com.stefano.web.dto.usuario.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(AuthRequest authRequest);
}
