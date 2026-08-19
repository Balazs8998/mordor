package com.mordor.backend.creature.equipment.enums;

public enum EquipmentSlots {
    HEAD,
    BODY,
    RIGHT_HAND,
    LEFT_HAND,
    FEET;

    private final String displayName;

    EquipmentSlots() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public String getDisplayName() {
        return displayName;
    }
}
