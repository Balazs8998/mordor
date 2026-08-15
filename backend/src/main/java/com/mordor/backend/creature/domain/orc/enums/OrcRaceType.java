package com.mordor.backend.creature.domain.orc.enums;

public enum OrcRaceType {
    SNAGA(OrcRole.SLAVE,"snaga/snaga"),
    URUK(OrcRole.WARRIOR,"uruk/uruk"),
    MOUNTAIN_ORC(OrcRole.HEAVY_WARRIOR,"mountain-orc/mountain-orc"),
    URUK_HAI(OrcRole.ELITE_WARRIOR,"uruk-hai/uruk-hai");

    private final OrcRole role;
    private final String displayName;
    private final String imgUrl;

    OrcRaceType(OrcRole role, String imgUrl) {
        String formatted = name().replace("_", " ").toLowerCase();
        String baseImgUrl = "img/army/orc/";

        this.role = role;
        this.imgUrl = baseImgUrl + imgUrl + ".png";
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
    }

    public OrcRole getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
