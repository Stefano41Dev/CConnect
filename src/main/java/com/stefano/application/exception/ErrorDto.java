package com.stefano.application.exception;

import java.time.LocalDateTime;

public record ErrorDto(
        String mensaje,
        LocalDateTime fecha
) {
}
