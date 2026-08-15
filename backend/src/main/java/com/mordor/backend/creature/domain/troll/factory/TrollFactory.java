package com.mordor.backend.creature.domain.troll.factory;

import com.mordor.backend.creature.domain.troll.domain.Troll;
import com.mordor.backend.creature.domain.troll.enums.TrollRaceType;
import org.springframework.stereotype.Component;

@Component
public class TrollFactory {

    public Troll createCaveTroll(){
        Troll troll = new Troll();

        troll.setName("Cave Troll");
        troll.setRaceType(TrollRaceType.CAVE_TROLL);

        troll.setLevel(1);
        troll.setStrength(2);

        troll.setHealth(30.0);
        troll.setDamage(2.0);
        troll.setDefense(1.0);

        troll.setCurrentHealth(30.0);

        return troll;
    }

    public Troll createMountainTroll(){
        Troll troll = new Troll();

        troll.setName("Mountain Troll");
        troll.setRaceType(TrollRaceType.MOUNTAIN_TROLL);

        troll.setLevel(1);
        troll.setStrength(4);

        troll.setHealth(40.0);
        troll.setDamage(4.0);
        troll.setDefense(2.0);

        troll.setCurrentHealth(40.0);

        return troll;
    }

    public Troll createOlogHai(){
        Troll troll = new Troll();

        troll.setName("Olog-Hai");
        troll.setRaceType(TrollRaceType.OLOG_HAI);

        troll.setLevel(1);
        troll.setStrength(6);

        troll.setHealth(50.0);
        troll.setDamage(6.0);
        troll.setDefense(3.0);

        troll.setCurrentHealth(50.0);

        return troll;
    }

}
