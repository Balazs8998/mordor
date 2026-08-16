package com.mordor.backend.creature.factory;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.shared.CreatureRaceDefinition;

public abstract class AbstractCreatureFactory {

    protected void initializeCreature(
            Creature creature,
            CreatureRaceDefinition raceDefinition,
            String name
    ) {
        creature.setName(name);
        creature.setLevel(1);

        creature.setMovementSpeed(
                raceDefinition.getMovementSpeed()
        );

        creature.setStrength(
                raceDefinition.getStrength()
        );

        creature.setCurrentStrength(
                raceDefinition.getStrength()
        );

        creature.setHealth(
                raceDefinition.getBaseHealth()
        );

        creature.setCurrentHealth(
                raceDefinition.getBaseHealth()
        );

        creature.setDamage(
                raceDefinition.getBaseDamage()
        );

        creature.setDefense(
                raceDefinition.getBaseDefense()
        );

        creature.setFoodUpkeep(
                raceDefinition.getFoodUpkeep()
        );

        creature.setCapacityCost(
                raceDefinition.getCapacityCost()
        );
    }
}