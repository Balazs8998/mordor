package com.mordor.backend.creature.domain.orc.factory;

import com.mordor.backend.creature.domain.orc.domain.Orc;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.factory.AbstractCreatureFactory;
import org.springframework.stereotype.Component;

@Component
public class OrcFactory extends AbstractCreatureFactory {

    public Orc createOrcCreature(
            String raceTypeValue,
            String name
    ) {
        OrcRaceType raceType =
                OrcRaceType.valueOf(raceTypeValue);

        Orc orc = new Orc();

        orc.setRaceType(raceType);

        initializeCreature(
                orc,
                raceType,
                name
        );

        return orc;
    }


}