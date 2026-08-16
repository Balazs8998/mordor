package com.mordor.backend.creature.domain.troll.factory;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.flying.domain.Flying;
import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import com.mordor.backend.creature.domain.orc.domain.Orc;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.domain.troll.domain.Troll;
import com.mordor.backend.creature.domain.troll.enums.TrollRaceType;
import com.mordor.backend.creature.factory.AbstractCreatureFactory;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class TrollFactory extends AbstractCreatureFactory {

    public Troll createTrollCreature(
            String raceTypeValue,
            String name
    ) {
        TrollRaceType raceType =
                TrollRaceType.valueOf(raceTypeValue);

        Troll troll = new Troll();

        troll.setRaceType(raceType);

        initializeCreature(
                troll,
                raceType,
                name
        );

        return troll;
    }

}