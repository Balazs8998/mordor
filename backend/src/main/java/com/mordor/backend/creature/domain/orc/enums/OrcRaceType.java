package com.mordor.backend.creature.domain.orc.enums;

public enum OrcRaceType {
    SNAGA(OrcRole.SLAVE),
    URUK(OrcRole.WARRIOR),
    MOUNTAIN_ORC(OrcRole.HEAVY_WARRIOR),
    URUK_HAI(OrcRole.ELITE_WARRIOR);

    private final OrcRole role;
    private final String displayName;

    OrcRaceType(OrcRole role) {
        String formatted = name().replace("_", " ").toLowerCase();

        this.role = role;
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public OrcRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }
}
