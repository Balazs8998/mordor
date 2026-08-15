package com.mordor.backend.creature.domain.flying.enums;

import com.mordor.backend.creature.domain.troll.enums.TrollRole;

public enum FlyingRaceType {

    GIANT_BAT(FlyingRole.FLYING_SCOUT),
    GIANT_WAR_BAT(FlyingRole.FLYING_WARRIOR),
    FLYING_WAR_CERBERUS(FlyingRole.ELITE_FLYING_WARRIOR);

    private final FlyingRole role;

    private final String displayName;

    FlyingRaceType(FlyingRole role) {
        this.role = role;
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public FlyingRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

}
