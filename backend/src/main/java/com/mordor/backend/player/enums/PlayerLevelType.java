package com.mordor.backend.player.enums;

public enum PlayerLevelType {

    LEVEL_1(
            500,
            150,
            20,
            80,
            5,
            1
    ),

    LEVEL_2(
            1200,
            220,
            24,
            96,
            6,
            1
    ),

    LEVEL_3(
            2500,
            380,
            28,
            112,
            9,
            2
    ),

    LEVEL_4(
            4500,
            530,
            32,
            128,
            11,
            2
    ),

    LEVEL_5(
            7000,
            760,
            36,
            144,
            14,
            3
    ),

    LEVEL_6(
            0,
            1080,
            40,
            160,
            18,
            3
    );

    private final String displayName;
    private final int levelUpExperience;

    private final int maxCreatureCapacity;

    private final int maxWarbandCapacity;
    private final int maxHordeCapacity;

    private final int maxWarbandCount;
    private final int maxHordeCount;

    PlayerLevelType(
            int levelUpExperience,
            int maxCreatureCapacity,
            int maxWarbandCapacity,
            int maxHordeCapacity,
            int maxWarbandCount,
            int maxHordeCount
    ) {
        this.displayName = "Level " + (this.ordinal() + 1);
        this.levelUpExperience = levelUpExperience;
        this.maxCreatureCapacity = maxCreatureCapacity;
        this.maxWarbandCapacity = maxWarbandCapacity;
        this.maxHordeCapacity = maxHordeCapacity;
        this.maxWarbandCount = maxWarbandCount;
        this.maxHordeCount = maxHordeCount;
    }

    public int getLevelUpExperience() {
        return levelUpExperience;
    }

    public int getMaxCreatureCapacity() {
        return maxCreatureCapacity;
    }

    public int getMaxWarbandCapacity() {
        return maxWarbandCapacity;
    }

    public int getMaxHordeCapacity() {
        return maxHordeCapacity;
    }

    public int getMaxWarbandCount() {
        return maxWarbandCount;
    }

    public int getMaxHordeCount() {
        return maxHordeCount;
    }
    public String getDisplayName() {
        return displayName;
    }
}
