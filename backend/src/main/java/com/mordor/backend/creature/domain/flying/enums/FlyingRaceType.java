package com.mordor.backend.creature.domain.flying.enums;

import com.mordor.backend.creature.domain.troll.enums.TrollRole;

public enum FlyingRaceType {

    GIANT_BAT(FlyingRole.FLYING_SCOUT),
    GIANT_WAR_BAT(FlyingRole.FLYING_WARRIOR),
    FLYING_WAR_CERBERUS(FlyingRole.ELITE_FLYING_WARRIOR);

    private final FlyingRole role;

    FlyingRaceType(FlyingRole role) {
        this.role = role;
    }

    public FlyingRole getRole() {
        return role;
    }

}
