package com.mordor.backend.creature.equipment.enums;

public enum CombatRange {

    MELEE,
    RANGED,
    CAVALRY,
    FLYING;

    private final String displayName;

    CombatRange() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }
    public String getDisplayName() {
        return displayName;
    }

}
