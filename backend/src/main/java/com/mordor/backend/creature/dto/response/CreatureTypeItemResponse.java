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

        Double strength,
        Double agility,
        Double intelligence,

        Double baseHealth,
        Double baseDamage,
        Double baseDefense,

        Double morale,

        Double movementSpeed,

        Integer foodUpkeep,
        Integer capacityCost,


        Integer recruitmentGoldCost,
        Integer recruitmentMordorSteelCost,

        String imgUrl
) {
}