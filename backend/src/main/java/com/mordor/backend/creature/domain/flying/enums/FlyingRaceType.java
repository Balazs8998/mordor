package com.mordor.backend.creature.domain.flying.enums;

import com.mordor.backend.creature.domain.troll.enums.TrollRole;

public enum FlyingRaceType {

    GIANT_BAT(FlyingRole.FLYING_SCOUT,"giant-bat/giant-bat"),
    GIANT_WAR_BAT(FlyingRole.FLYING_WARRIOR,"giant-war-bat/giant-war-bat"),
    FLYING_WAR_CERBERUS(FlyingRole.ELITE_FLYING_WARRIOR,"flying-war-cerberus/giant-war-cerberus");

    private final FlyingRole role;
    private final String imgUrl;
    private final String displayName;

    FlyingRaceType(FlyingRole role, String imgUrl) {
        String baseImgUrl = "img/army/flying/";
        String formatted = name().replace("_", " ").toLowerCase();
        this.role = role;
        this.imgUrl = baseImgUrl + imgUrl + ".png";
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public FlyingRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
