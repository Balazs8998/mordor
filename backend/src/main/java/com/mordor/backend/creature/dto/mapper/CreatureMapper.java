package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
import com.mordor.backend.creature.enums.CreatureType;
import com.mordor.backend.creature.equipment.domain.BeastEquipment;
import com.mordor.backend.creature.equipment.domain.HumanoidEquipment;
import org.springframework.stereotype.Component;

@Component
public class CreatureMapper {

    private final EquipmentMapper equipmentMapper;

    public CreatureMapper(EquipmentMapper equipmentMapper) {
        this.equipmentMapper = equipmentMapper;
    }

    public CreatureItemResponse getCreatureItemResponse(Creature creature) {
        if (creature == null) {
            return null;
        }

        CreatureType creatureType = CreatureType.valueOf(creature.getCreatureTypeValue());

        if (creatureType == CreatureType.ORC || creatureType == CreatureType.TROLL) {

            return new CreatureItemResponse(
                    creature.getId(),
                    creature.getName(),
                    creature.getLevel(),

                    creature.getraceTypeValue(),
                    creature.getraceTypeDisplayName(),
                    creature.getRoleDisplayName(),
                    creature.getCreatureTypeDisplayName(),

                    creature.getStrength(),
                    creature.getAgility(),
                    creature.getIntelligence(),

                    creature.getHealth(),
                    creature.getDamage() + ((HumanoidEquipment)creature.getEquipment()).getBonusDamage(),
                    creature.getDefense() + ((HumanoidEquipment)creature.getEquipment()).getBonusDefense(),

                    creature.getMorale(),

                    creature.getMovementSpeed(),
                    creature.getStrengthLoad(),
                    creature.getCurrentHealth(),

                    creature.getFoodUpkeep(),
                    creature.getCapacityCost(),

                    creature.getWeaponCount(),
                    creature.getImgUrl(),
                    equipmentMapper.humanoidEquipmentToEquipmentItemResponse((HumanoidEquipment) creature.getEquipment())

            );

        }

        return new CreatureItemResponse(
                creature.getId(),
                creature.getName(),
                creature.getLevel(),

                creature.getraceTypeValue(),
                creature.getraceTypeDisplayName(),
                creature.getRoleDisplayName(),
                creature.getCreatureTypeDisplayName(),

                creature.getStrength(),
                creature.getAgility(),
                creature.getIntelligence(),

                creature.getHealth(),
                creature.getDamage(),
                creature.getDefense(),

                creature.getMorale(),

                creature.getMovementSpeed(),
                creature.getStrengthLoad(),
                creature.getCurrentHealth(),

                creature.getFoodUpkeep(),
                creature.getCapacityCost(),

                creature.getWeaponCount(),
                creature.getImgUrl(),
                equipmentMapper.beastEquipmentToEquipmentItemResponse((BeastEquipment) creature.getEquipment())

        );
    }




}
