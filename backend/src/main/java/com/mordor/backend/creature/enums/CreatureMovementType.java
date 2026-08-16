package com.mordor.backend.creature.enums;

public enum CreatureMovementType {
    GROUND,
    FLYING;

    private final String displayName;

    CreatureMovementType() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }
    public String getDisplayName() {
        return displayName;
    }
}