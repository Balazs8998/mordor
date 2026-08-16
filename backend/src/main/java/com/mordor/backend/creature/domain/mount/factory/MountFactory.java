package com.mordor.backend.creature.domain.mount.factory;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.flying.domain.Flying;
import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import com.mordor.backend.creature.domain.mount.domain.Mount;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import com.mordor.backend.creature.domain.orc.domain.Orc;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.factory.AbstractCreatureFactory;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class MountFactory extends AbstractCreatureFactory {


    public Mount createMountCreature(
            String raceTypeValue,
            String name
    ) {
        MountRaceType raceType =
                MountRaceType.valueOf(raceTypeValue);

        Mount mount = new Mount();

        mount.setRaceType(raceType);

        initializeCreature(
                mount,
                raceType,
                name
        );

        return mount;
    }

}