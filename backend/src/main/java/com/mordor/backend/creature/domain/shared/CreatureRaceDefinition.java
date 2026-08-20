package com.mordor.backend.creature.domain.shared;

public interface CreatureRaceDefinition {


    Double getStrength();
    Double getAgility();
    Double getIntelligence();

    Double getBaseHealth();
    Double getBaseDamage();
    Double getBaseDefense();

    Double getMorale();
    Double getMovementSpeed();

    Integer getFoodUpkeep();
    Integer getCapacityCost();
}
