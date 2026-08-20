package com.mordor.backend.creature.factory;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.shared.CreatureRaceDefinition;
import com.mordor.backend.creature.equipment.domain.Equipment;

public abstract class AbstractCreatureFactory {

    protected void initializeCreature(
            Creature creature,
            CreatureRaceDefinition raceDefinition,
            String name
    ) {
        creature.setName(name);
        creature.setLevel(1);

        creature.setStrength(
                raceDefinition.getStrength()
        );
        creature.setAgility(
                raceDefinition.getAgility()
        );
        creature.setIntelligence(
                raceDefinition.getIntelligence()
        );

        creature.setHealth(
                raceDefinition.getBaseHealth()
        );

        creature.setDamage(
                raceDefinition.getBaseDamage()
        );

        creature.setDefense(
                raceDefinition.getBaseDefense()
        );

        creature.setMorale(
                raceDefinition.getMorale()
        );

        creature.setMovementSpeed(
                raceDefinition.getMovementSpeed()
        );

        creature.setStrengthLoad(
                raceDefinition.getStrength()
        );

        creature.setCurrentHealth(
                raceDefinition.getBaseHealth()
        );

        creature.setFoodUpkeep(
                raceDefinition.getFoodUpkeep()
        );

        creature.setCapacityCost(
                raceDefinition.getCapacityCost()
        );

    }
}