package com.mordor.backend.creature.domain.mount.enums;

import com.mordor.backend.creature.domain.shared.CreatureRaceDefinition;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;

public enum MountRaceType implements CreatureRaceDefinition {

    WARG(
            MountRole.BEAST_MOUNT,
            "warg/warg",
            3,
            3.0,
            35.0,
            4.0,
            1.0,
            45,
            0,
            3,
            1
    ),

    WAR_WARG(
            MountRole.WAR_BEAST,
            "war-warg/war-warg",
            5,
            4.0,
            50.0,
            5.0,
            2.0,
            80,
            1,
            4,
            1
    );

    private final MountRole role;
    private final String displayName;
    private final String imgUrl;

    private final Integer strength;
    private final Double movementSpeed;

    private final Double baseHealth;
    private final Double baseDamage;
    private final Double baseDefense;

    private final Integer recruitmentGoldCost;
    private final Integer recruitmentMordorSteelCost;

    private final Integer foodUpkeep;
    private final Integer capacityCost;

    private final CreatureType creatureType = CreatureType.MOUNT;
    private final CreatureMovementType movementType = CreatureMovementType.GROUND;

    MountRaceType(
            MountRole role,
            String imgUrl,
            Integer strength,
            Double movementSpeed,
            Double baseHealth,
            Double baseDamage,
            Double baseDefense,
            Integer recruitmentGoldCost,
            Integer recruitmentMordorSteelCost,
            Integer foodUpkeep,
            Integer capacityCost
    ) {
        this.role = role;
        this.strength = strength;
        this.movementSpeed = movementSpeed;

        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseDefense = baseDefense;

        this.recruitmentGoldCost = recruitmentGoldCost;
        this.recruitmentMordorSteelCost = recruitmentMordorSteelCost;

        this.foodUpkeep = foodUpkeep;
        this.capacityCost = capacityCost;

        String baseImgUrl = "img/army/mount/";
        this.imgUrl = baseImgUrl + imgUrl + ".png";

        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
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

    public Integer getStrength() {
        return strength;
    }

    public Double getMovementSpeed() {
        return movementSpeed;
    }

    public Double getBaseHealth() {
        return baseHealth;
    }

    public Double getBaseDamage() {
        return baseDamage;
    }

    public Double getBaseDefense() {
        return baseDefense;
    }

    public Integer getRecruitmentGoldCost() {
        return recruitmentGoldCost;
    }

    public Integer getRecruitmentMordorSteelCost() {
        return recruitmentMordorSteelCost;
    }

    public Integer getFoodUpkeep() {
        return foodUpkeep;
    }

    public Integer getCapacityCost() {
        return capacityCost;
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public CreatureMovementType getMovementType() {
        return movementType;
    }
}