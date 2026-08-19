package com.mordor.backend.creature.domain.orc.factory;

import com.mordor.backend.creature.domain.orc.domain.Orc;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.creature.equipment.domain.HumanoidEquipment;
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
        Equipment equipment = new HumanoidEquipment();
        equipment.setCreature(orc);


        orc.setRaceType(raceType);
        orc.setEquipment(equipment);

        initializeCreature(
                orc,
                raceType,
                name
        );

        return orc;
    }


}