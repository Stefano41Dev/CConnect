package com.stefano.web.dto.usuario;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
