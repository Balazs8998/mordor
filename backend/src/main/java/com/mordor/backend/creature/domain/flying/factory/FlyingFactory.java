package com.mordor.backend.creature.domain.flying.factory;

import com.mordor.backend.creature.domain.flying.domain.Flying;
import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import com.mordor.backend.creature.domain.mount.domain.Mount;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import com.mordor.backend.creature.factory.AbstractCreatureFactory;
import org.springframework.stereotype.Component;

@Component
public class FlyingFactory extends AbstractCreatureFactory {

    public Flying createFlyingCreature(
            String raceTypeValue,
            String name
    ) {
        FlyingRaceType raceType =
                FlyingRaceType.valueOf(raceTypeValue);

        Flying flying = new Flying();

        flying.setRaceType(raceType);

        initializeCreature(
                flying,
                raceType,
                name
        );

        return flying;
    }

}