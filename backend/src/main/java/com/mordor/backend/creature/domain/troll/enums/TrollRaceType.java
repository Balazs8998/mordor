package com.mordor.backend.creature.domain.troll.enums;

public enum TrollRaceType {

    CAVE_TROLL(TrollRole.BRUTE),
    MOUNTAIN_TROLL(TrollRole.HEAVY_BRUTE),
    OLOG_HAI(TrollRole.ELITE_BRUTE);

    private final TrollRole role;

    TrollRaceType(TrollRole role) {
        this.role = role;
    }

    public TrollRole getRole() {
        return role;
    }

}
