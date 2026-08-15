package com.mordor.backend.creature.domain.mount.enums;

public enum MountRole {

    BEAST_MOUNT,
    WAR_BEAST;

    private final String displayName;

    MountRole() {
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public String getDisplayName() {
        return displayName;
    }

}
