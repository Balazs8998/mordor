package com.mordor.backend.orc.mapper;


import com.mordor.backend.orc.domain.Orc;
import com.mordor.backend.orc.domain.enums.RaceType;
import com.mordor.backend.orc.domain.enums.WeaponType;
import com.mordor.backend.orc.dto.request.OrcCreateRequest;
import com.mordor.backend.orc.dto.response.OrcItemResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrcMapper {

    public Orc newOrcDtoToEntity(OrcCreateRequest request) {
        Orc orc = new Orc();
        orc.setName(request.name());
        orc.setRaceType(RaceType.valueOf(request.race().toUpperCase()));
        orc.setKills(request.kills() != null ? request.kills() : 0);
        orc.setWeaponTypes(request.weapons().stream()
                .map(weapon -> WeaponType.valueOf(weapon.toUpperCase()))
                .toList());
        return orc;
    }

    public Orc updateOrcDtoToEntity(Orc orc, OrcCreateRequest request) {

        List<WeaponType> weaponTypeList = request.weapons().stream()
                .map(weapon -> WeaponType.valueOf(weapon.toUpperCase()))
                .toList();

        orc.setId(request.id());
        orc.setName(request.name());
        orc.setRaceType(RaceType.valueOf(request.race().toUpperCase()));
        orc.setKills(request.kills() != null ? request.kills() : 0);
        orc.getWeaponTypes().clear();
        orc.getWeaponTypes().addAll(weaponTypeList);

        return orc;
    }

    public OrcItemResponse orcToItemResponse(Orc orc) {
        return new OrcItemResponse(
                orc.getId(),
                orc.getName(),
                orc.getRaceType().getDisplayName(),
                orc.getWeaponTypes().stream().map(WeaponType::getDisplayName).toList(),
                orc.getKills()
        );
    }

}
