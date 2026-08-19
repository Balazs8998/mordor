package com.mordor.backend.creature.dto.response;

public record WeaponTypeItemResponse(
        String iconImgUrl,
        String imgUrl,
        String value,
        String displayName,
        String combatRangeValue,
        String combatRangeDisplayName,
        Integer damageBonus,
        Integer defenseBonus,
        Integer strengthCost,
        Integer range,
        Integer requiredStrength,
        Integer goldCost,
        Integer mordorSteelCost

) {
}
