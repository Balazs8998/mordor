package com.mordor.backend.creature.domain.troll.enums;

public enum TrollRaceType {

    CAVE_TROLL(TrollRole.BRUTE),
    MOUNTAIN_TROLL(TrollRole.HEAVY_BRUTE),
    OLOG_HAI(TrollRole.ELITE_BRUTE);

    private final TrollRole role;
    private final String displayName;

    TrollRaceType(TrollRole role) {
        this.role = role;
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public TrollRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

}
