package com.mordor.backend.orc.dto.response;

import java.util.List;

public record OrcCreateRequiedResponse(
    List<RaceTypeItemResponse> raceTypes,
    List<WeaponTypeItemResponse> weaponTypes
) {
}
