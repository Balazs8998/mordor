package com.mordor.backend.creature.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreatureCreateRequest(

        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Race is required")
        String raceTypeValue,
        @NotBlank(message = "Creature type is required")
        String creatureTypeValue
) {
}
