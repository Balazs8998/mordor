package com.mordor.backend.horde.dto.request;

import jakarta.validation.constraints.NotBlank;

public record HordeCreateRequest(

        @NotBlank(message = "Name is required")
        String name
) {
}
