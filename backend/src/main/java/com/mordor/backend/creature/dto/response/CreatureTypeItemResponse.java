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

        Double baseStrength,
        Double baseAgility,
        Double baseIntelligence,

        Double baseHealth,
        Double baseDamage,
        Double baseDefense,

        Double baseMorale,

        Double baseMovementSpeed,

        Integer foodUpkeep,
        Integer capacityCost,


        Integer recruitmentGoldCost,
        Integer recruitmentMordorSteelCost,

        String imgUrl
) {
}