package com.mordor.backend.orc.domain.enums;


public enum WeaponType {

    SWORD,
    BOW,
    DOUBLE_EDGE_SWORD,
    SHIELD,
    KNIFE;

    private final String displayName;

    WeaponType(){
        this.displayName = this.name().toLowerCase();
    }

    public String getDisplayName() {
        return displayName;
    }
}
