package com.mordor.backend.orc.domain.enums;

public enum RaceType {
    MOUNTAIN,
    URUK,
    URUK_HANAI,
    SNAGA;

    private String displayName;

    RaceType() {
        this.displayName = this.name().toLowerCase();
    }
    public String getDisplayName() {
        return displayName;
    }
}
