package com.mordor.backend.creature.domain.mount.enums;

public enum MountRaceType {
    WARG(MountRole.BEAST_MOUNT,"none"),
    WAR_WARG(MountRole.WAR_BEAST,"none");

    private final MountRole role;
    private final String displayName;
    private final String imgUrl;

    MountRaceType(MountRole role, String imgUrl) {

        String baseImgUrl = "img/army/mount/";
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
        this.role = role;
        this.imgUrl = baseImgUrl + imgUrl + ".png";
    }

    public MountRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
