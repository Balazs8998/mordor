package com.mordor.backend.creature.dto.response;


import java.util.List;

public record CreatureForgeRequiredDataResponse(
        List<CreatureTypeItemResponse> orcRaceTypes,
        List<CreatureTypeItemResponse> trollRaceTypes,
        List<CreatureTypeItemResponse> mountRaceTypes,
        List<CreatureTypeItemResponse> flyingRaceTypes,
        List<WeaponTypeItemResponse> weaponTypes
) {
}
