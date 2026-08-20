package com.mordor.backend.creature.dto.response;

public record WeaponTypeItemResponse(
        String iconImgUrl,
        String imgUrl,
        String leftHandLayerImgUrl,
        String rightHandLayerImgUrl,
        String twoHandLayerImgUrl,

        String value,
        String displayName,
        String combatRangeValue,
        String combatRangeDisplayName,

        Integer handsRequired,

        Integer damageBonus,
        Integer defenseBonus,
        Integer strengthCost,
        Integer range,
        Integer requiredStrength,

        Integer goldCost,
        Integer mordorSteelCost

) {
}
