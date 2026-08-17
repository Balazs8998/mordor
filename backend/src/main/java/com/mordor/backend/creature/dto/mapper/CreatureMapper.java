package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
import org.springframework.stereotype.Component;

@Component
public class CreatureMapper {

    public CreatureItemResponse getCreatureItemResponse(Creature creature) {
        if (creature == null) {
            return null;
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
                creature.getCurrentStrength(),
                creature.getMovementSpeed(),
                creature.getHealth(),
                creature.getCurrentHealth(),
                creature.getDamage(),
                creature.getDefense(),
                creature.getFoodUpkeep(),
                creature.getCapacityCost(),
                creature.getWeaponCount(),
                creature.getImgUrl()

        );
    }




}
