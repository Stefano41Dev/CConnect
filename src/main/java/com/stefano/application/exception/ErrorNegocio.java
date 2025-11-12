package com.stefano.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ErrorNegocio extends RuntimeException {
    private final HttpStatus status;
    public ErrorNegocio(String mensaje,HttpStatus status) {
        super(mensaje);
        this.status = status;
    }
}
