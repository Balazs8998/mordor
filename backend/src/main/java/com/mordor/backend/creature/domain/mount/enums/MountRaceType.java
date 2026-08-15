package com.mordor.backend.creature.domain.mount.enums;

public enum MountRaceType {
    WARG(MountRole.BEAST_MOUNT),
    WAR_WARG(MountRole.WAR_BEAST);

    private final MountRole role;

    MountRaceType(MountRole role) {
        this.role = role;
    }

    public MountRole getRole() {
        return role;
    }

}
