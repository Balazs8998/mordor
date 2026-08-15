package com.mordor.backend.creature.dto.response;


import com.mordor.backend.equipment.dto.response.WeaponTypeItemResponse;
import java.util.List;

public record CreatureForgeRequiredDataResponse(
        List<CreatureTypeItemResponse> orcRaceTypes,
        List<CreatureTypeItemResponse> trollRaceTypes,
        List<CreatureTypeItemResponse> flyingRaceTypes,
        List<CreatureTypeItemResponse> mountRaceTypes,
        List<WeaponTypeItemResponse> weaponTypes
) {
}
