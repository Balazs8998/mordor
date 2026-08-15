package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.domain.troll.enums.TrollRaceType;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureTypeItemResponse;
import com.mordor.backend.equipment.dto.response.WeaponTypeItemResponse;
import com.mordor.backend.equipment.enums.WeaponType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class CreatureForgeRequiredDataMapper {


    public CreatureForgeRequiredDataResponse toResponse() {
        return new CreatureForgeRequiredDataResponse(
                orcRaceTypesToResponse(),
                trollRaceTypesToResponse(),
                flyingRaceTypesToResponse(),
                mountRaceTypesToResponse(),
                weaponTypesToResponse()
        );
    }


    private List<WeaponTypeItemResponse> weaponTypesToResponse(){

        return Stream.of(WeaponType.values())
                .map(weaponType -> new WeaponTypeItemResponse(
                        weaponType.name(),
                        weaponType.getDisplayName(),
                        weaponType.getCombatRange().name(),
                        weaponType.getCombatRange().getDisplayName(),
                        weaponType.getDamageBonus(),
                        weaponType.getDefenseBonus(),
                        weaponType.getRange(),
                        weaponType.getRequiredStrength()
                ))
                .toList();
    }



    private List<CreatureTypeItemResponse> orcRaceTypesToResponse() {

        return Stream.of(OrcRaceType.values())
                .map(orcRaceType -> new CreatureTypeItemResponse(
                        orcRaceType.name(),
                        orcRaceType.getDisplayName(),
                        orcRaceType.getRole().name(),
                        orcRaceType.getRole().getDisplayName(),
                        orcRaceType.getImgUrl()
                ))
                .toList();
    }

    private List<CreatureTypeItemResponse> trollRaceTypesToResponse() {


        return Stream.of(TrollRaceType.values())
                .map(trollRaceType -> new CreatureTypeItemResponse(
                        trollRaceType.name(),
                        trollRaceType.getDisplayName(),
                        trollRaceType.getRole().name(),
                        trollRaceType.getRole().getDisplayName(),
                        trollRaceType.getImgUrl()
                ))
                .toList();
    }

    private List<CreatureTypeItemResponse> mountRaceTypesToResponse() {


        return Stream.of(MountRaceType.values())
                .map(mountRaceType -> new CreatureTypeItemResponse(
                        mountRaceType.name(),
                        mountRaceType.getDisplayName(),
                        mountRaceType.getRole().name(),
                        mountRaceType.getRole().getDisplayName(),
                        mountRaceType.getImgUrl()
                ))
                .toList();
    }

    private List<CreatureTypeItemResponse> flyingRaceTypesToResponse() {

        return Stream.of(FlyingRaceType.values())
                .map(flyingRaceType -> new CreatureTypeItemResponse(
                        flyingRaceType.name(),
                        flyingRaceType.getDisplayName(),
                        flyingRaceType.getRole().name(),
                        flyingRaceType.getRole().getDisplayName(),
                        flyingRaceType.getImgUrl()
                ))
                .toList();
    }
}
