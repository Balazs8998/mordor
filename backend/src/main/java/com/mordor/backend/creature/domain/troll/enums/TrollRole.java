package com.mordor.backend.creature.domain.troll.enums;

public enum TrollRole {
    BRUTE,
    HEAVY_BRUTE,
    ELITE_BRUTE;

    private final String displayName;

    TrollRole() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public String getDisplayName() {
        return displayName;
    }
}
