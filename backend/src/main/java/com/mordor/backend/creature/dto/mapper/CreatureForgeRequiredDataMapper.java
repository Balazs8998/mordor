package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.domain.troll.enums.TrollRaceType;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureTypeItemResponse;
import com.mordor.backend.creature.dto.response.WeaponTypeItemResponse;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class CreatureForgeRequiredDataMapper {


    public CreatureForgeRequiredDataResponse toResponse() {
        return new CreatureForgeRequiredDataResponse(
                creatureRaceTypesToResponse(List.of(OrcRaceType.values())),
                creatureRaceTypesToResponse(List.of(TrollRaceType.values())),
                creatureRaceTypesToResponse(List.of(MountRaceType.values())),
                creatureRaceTypesToResponse(List.of(FlyingRaceType.values())),
                weaponTypesToResponse()
        );
    }

    private List<WeaponTypeItemResponse> weaponTypesToResponse() {

        return Stream.of(WeaponType.values())
                .map(weaponType -> new WeaponTypeItemResponse(

                        weaponType.getIconImgUrl(),
                        weaponType.getImgUrl(),
                        weaponType.getLeftHandLayerImgUrl(),
                        weaponType.getRightHandLayerImgUrl(),
                        weaponType.getTwoHandLayerImgUrl(),

                        weaponType.name(),
                        weaponType.getDisplayName(),

                        weaponType.getCombatRange().name(),
                        weaponType.getCombatRange().getDisplayName(),

                        weaponType.getDamageBonus(),
                        weaponType.getDefenseBonus(),
                        weaponType.getStrengthCost(),
                        weaponType.getRange(),
                        weaponType.getStrengthCost(),

                        weaponType.getGoldCost(),
                        weaponType.getMordorSteelCost()
                ))
                .toList();

    }



    private List<CreatureTypeItemResponse> creatureRaceTypesToResponse(List<CreatureTypeMapperInterface> creatureTypeMapperInterfaces) {

        return creatureTypeMapperInterfaces.stream()
                .map(creatureRaceType -> new CreatureTypeItemResponse(
                        creatureRaceType.getTypeValue(),
                        creatureRaceType.getTypeDisplayName(),

                        creatureRaceType.getRoleValue(),
                        creatureRaceType.getRoleDisplayName(),

                        creatureRaceType.getCreatureTypeValue(),
                        creatureRaceType.getCreatureTypeDisplayName(),

                        creatureRaceType.getMovementTypeValue(),
                        creatureRaceType.getMovementTypeDisplayName(),

                        creatureRaceType.getStrength(),
                        creatureRaceType.getMovementSpeed(),

                        creatureRaceType.getBaseHealth(),
                        creatureRaceType.getBaseDamage(),
                        creatureRaceType.getBaseDefense(),

                        creatureRaceType.getRecruitmentGoldCost(),
                        creatureRaceType.getRecruitmentMordorSteelCost(),
                        creatureRaceType.getFoodUpkeep(),
                        creatureRaceType.getCapacityCost(),

                        creatureRaceType.getImgUrl()
                )).toList();
    }

}
