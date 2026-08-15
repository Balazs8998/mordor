package com.mordor.backend.equipment.dto.response;

public record WeaponTypeItemResponse(
        String value,
        String displayName,
        String combatRangeValue,
        String combatRangeDisplayName,
        Integer damageBonus,
        Integer defenseBonus,
        Integer range,
        Integer requiredStrength

) {
}
