package com.mordor.backend.creature.domain.orc.enums;

public enum OrcRole {
    SLAVE,
    WARRIOR,
    HEAVY_WARRIOR,
    ELITE_WARRIOR;

    private final String displayName;

    OrcRole() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }
    public String getDisplayName() {
        return displayName;
    }
}
