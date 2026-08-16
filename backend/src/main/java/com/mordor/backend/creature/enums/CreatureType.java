package com.mordor.backend.creature.enums;

public enum CreatureType {
    ORC,
    TROLL,
    FLYING,
    MOUNT;

    private final String displayName;

    CreatureType() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public String getDisplayName() {
        return displayName;
    }

}
