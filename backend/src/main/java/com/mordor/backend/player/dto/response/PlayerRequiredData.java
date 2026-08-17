package com.mordor.backend.player.dto.response;

public record PlayerRequiredData(

        String PlayerLevelTypeValue,
        Integer levelUpExperience,
        Integer maxCreatureCapacity,
        Integer maxWarbandCapacity,
        Integer maxHordeCapacity,
        Integer maxWarbandCount,
        Integer maxHordeCount

) {
}
