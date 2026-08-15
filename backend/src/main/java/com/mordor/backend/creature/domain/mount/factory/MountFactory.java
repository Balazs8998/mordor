package com.mordor.backend.creature.domain.mount.factory;

import com.mordor.backend.creature.domain.mount.domain.Mount;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import org.springframework.stereotype.Component;

@Component
public class MountFactory {

    public Mount createWarg(){
        Mount mount = new Mount();

        mount.setName("Warg");
        mount.setRaceType(MountRaceType.WARG);


        mount.setLevel(1);
        mount.setStrength(2);

        mount.setHealth(20.0);
        mount.setDamage(2.0);
        mount.setDefense(1.0);

        mount.setCurrentHealth(20.0);

        return mount;
    }

    public Mount createWarWarg(){
        Mount mount = new Mount();

        mount.setName("War-Warg");
        mount.setRaceType(MountRaceType.WAR_WARG);

        mount.setLevel(1);
        mount.setStrength(4);

        mount.setHealth(40.0);
        mount.setDamage(4.0);
        mount.setDefense(2.0);

        mount.setCurrentHealth(40.0);

        return mount;

    }

}
