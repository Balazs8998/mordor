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

    private List<WeaponTypeItemResponse> weaponTypesToResponse() {

        return Stream.of(WeaponType.values())
                .map(weaponType -> new WeaponTypeItemResponse(
                        weaponType.name(),
                        weaponType.getDisplayName(),

                        weaponType.getCombatRange().name(),
                        weaponType.getCombatRange().getDisplayName(),

                        weaponType.getDamageBonus(),
                        weaponType.getDefenseBonus(),
                        weaponType.getRange(),
                        weaponType.getStrengthCost(),

                        weaponType.getGoldCost(),
                        weaponType.getMordorSteelCost()
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

                        orcRaceType.getCreatureType().name(),
                        orcRaceType.getCreatureType().getDisplayName(),

                        orcRaceType.getMovementType().name(),
                        orcRaceType.getMovementType().getDisplayName(),

                        orcRaceType.getStrength(),
                        orcRaceType.getMovementSpeed(),

                        orcRaceType.getBaseHealth(),
                        orcRaceType.getBaseDamage(),
                        orcRaceType.getBaseDefense(),

                        orcRaceType.getRecruitmentGoldCost(),
                        orcRaceType.getRecruitmentMordorSteelCost(),
                        orcRaceType.getFoodUpkeep(),
                        orcRaceType.getCapacityCost(),

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

                        trollRaceType.getCreatureType().name(),
                        trollRaceType.getCreatureType().getDisplayName(),

                        trollRaceType.getMovementType().name(),
                        trollRaceType.getMovementType().getDisplayName(),

                        trollRaceType.getStrength(),
                        trollRaceType.getMovementSpeed(),

                        trollRaceType.getBaseHealth(),
                        trollRaceType.getBaseDamage(),
                        trollRaceType.getBaseDefense(),

                        trollRaceType.getRecruitmentGoldCost(),
                        trollRaceType.getRecruitmentMordorSteelCost(),
                        trollRaceType.getFoodUpkeep(),
                        trollRaceType.getCapacityCost(),

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

                        mountRaceType.getCreatureType().name(),
                        mountRaceType.getCreatureType().getDisplayName(),

                        mountRaceType.getMovementType().name(),
                        mountRaceType.getMovementType().getDisplayName(),

                        mountRaceType.getStrength(),
                        mountRaceType.getMovementSpeed(),

                        mountRaceType.getBaseHealth(),
                        mountRaceType.getBaseDamage(),
                        mountRaceType.getBaseDefense(),

                        mountRaceType.getRecruitmentGoldCost(),
                        mountRaceType.getRecruitmentMordorSteelCost(),
                        mountRaceType.getFoodUpkeep(),
                        mountRaceType.getCapacityCost(),

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

                        flyingRaceType.getCreatureType().name(),
                        flyingRaceType.getCreatureType().getDisplayName(),

                        flyingRaceType.getMovementType().name(),
                        flyingRaceType.getMovementType().getDisplayName(),

                        flyingRaceType.getStrength(),
                        flyingRaceType.getMovementSpeed(),

                        flyingRaceType.getBaseHealth(),
                        flyingRaceType.getBaseDamage(),
                        flyingRaceType.getBaseDefense(),

                        flyingRaceType.getRecruitmentGoldCost(),
                        flyingRaceType.getRecruitmentMordorSteelCost(),
                        flyingRaceType.getFoodUpkeep(),
                        flyingRaceType.getCapacityCost(),

                        flyingRaceType.getImgUrl()
                ))
                .toList();
    }
}
