package com.mordor.backend.creature.domain.orc.factory;

import com.mordor.backend.creature.domain.orc.domain.Orc;
import com.mordor.backend.creature.domain.orc.enums.OrcRaceType;
import org.springframework.stereotype.Component;

@Component
public class OrcFactory {

    public Orc createSnaga(){
        Orc orc = new Orc();

        orc.setName("Snaga");
        orc.setRaceType(OrcRaceType.SNAGA);

        orc.setLevel(1);
        orc.setStrength(4);

        orc.setHealth(30.0);
        orc.setDamage(2.0);
        orc.setDefense(1.0);

        orc.setCurrentHealth(30.0);

        return orc;
    }

    public Orc createUruk(){
        Orc orc = new Orc();

        orc.setName("Uruk");
        orc.setRaceType(OrcRaceType.URUK);

        orc.setLevel(1);
        orc.setStrength(6);

        orc.setHealth(45.0);
        orc.setDamage(3.0);
        orc.setDefense(2.0);

        orc.setCurrentHealth(45.0);
        return orc;
    }

    public Orc createMountainOrc(){
        Orc orc = new Orc();

        orc.setName("Mountain Orc");
        orc.setRaceType(OrcRaceType.MOUNTAIN_ORC);

        orc.setLevel(1);
        orc.setStrength(8);

        orc.setHealth(60.0);
        orc.setDamage(4.0);
        orc.setDefense(3.0);

        orc.setCurrentHealth(60.0);

        return orc;
    }

    public Orc createUrukHai(){
        Orc orc = new Orc();

        orc.setName("Uruk-Hai");
        orc.setRaceType(OrcRaceType.URUK_HAI);

        orc.setLevel(1);
        orc.setStrength(10);

        orc.setHealth(75.0);
        orc.setDamage(5.0);
        orc.setDefense(4.0);

        orc.setCurrentHealth(75.0);

        return orc;
    }
}
