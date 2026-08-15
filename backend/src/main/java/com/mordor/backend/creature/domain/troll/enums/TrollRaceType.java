package com.mordor.backend.creature.domain.troll.enums;

public enum TrollRaceType {

    CAVE_TROLL(TrollRole.BRUTE,"none"),
    MOUNTAIN_TROLL(TrollRole.HEAVY_BRUTE,"none"),
    OLOG_HAI(TrollRole.ELITE_BRUTE,"none");

    private final TrollRole role;
    private final String displayName;
    private final String imgUrl;

    TrollRaceType(TrollRole role, String imgUrl) {
        this.role = role;
        String baseImgUrl = "img/army/troll/";
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
        this.imgUrl = baseImgUrl + imgUrl + ".png";
    }

    public TrollRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
