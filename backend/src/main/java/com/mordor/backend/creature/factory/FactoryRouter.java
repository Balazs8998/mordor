package com.mordor.backend.creature.factory;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.flying.factory.FlyingFactory;
import com.mordor.backend.creature.domain.mount.factory.MountFactory;
import com.mordor.backend.creature.domain.orc.factory.OrcFactory;
import com.mordor.backend.creature.domain.troll.factory.TrollFactory;
import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.enums.CreatureType;
import org.springframework.stereotype.Component;

@Component
public class FactoryRouter {

    private final OrcFactory orcFactory;
    private final TrollFactory trollFactory;
    private final MountFactory mountFactory;
    private final FlyingFactory flyingFactory;

    public FactoryRouter(OrcFactory orcFactory, TrollFactory trollFactory, MountFactory mountFactory, FlyingFactory flyingFactory) {
        this.orcFactory = orcFactory;
        this.trollFactory = trollFactory;
        this.mountFactory = mountFactory;
        this.flyingFactory = flyingFactory;
    }

    public Creature route(CreatureCreateRequest request) {
        CreatureType creatureType = CreatureType.valueOf(request.creatureTypeValue());
        String creatureName = request.name();

        switch (creatureType) {
            case FLYING -> { return flyingFactory.createFlyingCreature(request.raceTypeValue(), creatureName);
            }

            case MOUNT -> {
                 return mountFactory.createMountCreature(request.raceTypeValue(), creatureName);

            }
            case ORC -> {
                return orcFactory.createOrcCreature(request.raceTypeValue(), creatureName);
            }
            case TROLL -> {
                return trollFactory.createTrollCreature(request.raceTypeValue(), creatureName);
            }
        }
        return null;
    }

}
