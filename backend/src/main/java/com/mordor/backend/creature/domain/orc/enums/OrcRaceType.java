package com.mordor.backend.creature.domain.orc.enums;

public enum OrcRaceType {
    SNAGA(OrcRole.SLAVE),
    URUK(OrcRole.WARRIOR),
    MOUNTAIN_ORC(OrcRole.HEAVY_WARRIOR),
    URUK_HAI(OrcRole.ELITE_WARRIOR);

    private final OrcRole role;

    OrcRaceType(OrcRole role) {
        this.role = role;
    }

    public OrcRole getRole() {
        return role;
    }
}
