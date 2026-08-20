package com.mordor.backend.creature.dto.response;

public record CreatureItemResponse(
        Long id,
        String name,
        Integer level,

        String raceTypeValue,
        String raceTypeDisplayName,
        String roleDisplayName,
        String creatureTypeDisplayName,

        Double strength,
        Double agility,
        Double intelligence,

        Double health,
        Double damage,
        Double defense,

        Double morale,

        Double movementSpeed,
        Double strengthLoad,
        Double currentHealth,

        Integer foodUpkeep,
        Integer capacityCost,

        Integer weaponCount,
        String imgUrl,
        EquipmentItemResponse equipments

) {
}