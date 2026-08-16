package com.mordor.backend.creature.dto.response;

public record CreatureTypeItemResponse(
        String raceTypeValue,
        String raceTypeDisplayName,

        String roleValue,
        String roleDisplayName,

        String creatureTypeValue,
        String creatureTypeDisplayName,

        String movementTypeValue,
        String movementTypeDisplayName,

        Integer strength,
        Double movementSpeed,

        Double baseHealth,
        Double baseDamage,
        Double baseDefense,

        Integer recruitmentGoldCost,
        Integer recruitmentMordorSteelCost,
        Integer foodUpkeep,
        Integer capacityCost,

        String imgUrl
) {
}