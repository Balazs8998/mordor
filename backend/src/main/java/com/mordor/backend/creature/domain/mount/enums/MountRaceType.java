package com.mordor.backend.creature.domain.mount.enums;

public enum MountRaceType {
    WARG(MountRole.BEAST_MOUNT),
    WAR_WARG(MountRole.WAR_BEAST);

    private final MountRole role;
    private final String displayName;

    MountRaceType(MountRole role) {
        this.role = role;
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public MountRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

}
