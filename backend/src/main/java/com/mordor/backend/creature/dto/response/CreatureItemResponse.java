package com.mordor.backend.creature.dto.response;

public record CreatureItemResponse(
        Long id,
        String name,
        Integer level,
        String raceTypeValue,
        String raceTypeDisplayName,
        String roleDisplayName,
        String creatureTypeDisplayName,
        Integer strength,
        Integer currentStrength,
        Double movementSpeed,
        Double health,
        Double currentHealth,
        Double damage,
        Double defense,
        Integer foodUpkeep,
        Integer capacityCost,
        Integer weaponCount,
        String imgUrl

) {
}