package com.mordor.backend.creature.domain.flying.factory;

import com.mordor.backend.creature.domain.flying.domain.Flying;
import com.mordor.backend.creature.domain.flying.enums.FlyingRaceType;
import org.springframework.stereotype.Component;

@Component
public class FlyingFactory {

    public Flying createGaintBat(){

        Flying flying = new Flying();
        flying.setName("Gaint-Bat");
        flying.setRaceType(FlyingRaceType.GIANT_BAT);

        flying.setLevel(1);
        flying.setStrength(2);

        flying.setHealth(20.0);
        flying.setDamage(2.0);
        flying.setDefense(1.0);

        flying.setCurrentHealth(20.0);

        return flying;
    }

    public Flying createGaintWarBat(){

        Flying flying = new Flying();
        flying.setName("Gaint-War-Bat");
        flying.setRaceType(FlyingRaceType.GIANT_WAR_BAT);

        flying.setLevel(1);
        flying.setStrength(4);

        flying.setHealth(40.0);
        flying.setDamage(4.0);
        flying.setDefense(2.0);

        flying.setCurrentHealth(40.0);

        return flying;
    }

    public Flying createFlyingWarCerberus(){
        Flying flying = new Flying();

        flying.setName("Flying-War-Cerberus");
        flying.setRaceType(FlyingRaceType.FLYING_WAR_CERBERUS);

        flying.setLevel(1);
        flying.setStrength(6);

        flying.setHealth(60.0);
        flying.setDamage(6.0);
        flying.setDefense(3.0);

        flying.setCurrentHealth(60.0);

        return flying;
    }

}
