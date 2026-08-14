package com.mordor.backend.orc.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrcCreateRequest(

        Long id,
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Race is required")
        String race,
        Integer kills,
        @NotNull(message = "Weapons are required")
        List<String> weapons
) {
}
