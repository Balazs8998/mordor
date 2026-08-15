package com.mordor.backend.creature.domain.flying.enums;

public enum FlyingRole {
    FLYING_SCOUT,
    FLYING_WARRIOR,
    ELITE_FLYING_WARRIOR;

    private final String displayName;

    FlyingRole() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public String getDisplayName() {
        return displayName;
    }

}
