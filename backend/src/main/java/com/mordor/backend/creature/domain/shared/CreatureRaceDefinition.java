package com.mordor.backend.creature.domain.shared;

public interface CreatureRaceDefinition {

    Double getMovementSpeed();

    Integer getStrength();

    Double getBaseHealth();
    Double getBaseDamage();
    Double getBaseDefense();

    Integer getFoodUpkeep();
    Integer getCapacityCost();
}
