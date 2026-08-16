package com.mordor.backend.creature.domain.flying.enums;

import com.mordor.backend.creature.domain.shared.CreatureRaceDefinition;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;

public enum FlyingRaceType implements CreatureRaceDefinition {

    GIANT_BAT(
            FlyingRole.FLYING_SCOUT,
            "giant-bat/giant-bat",
            3,
            4.0,
            25.0,
            4.0,
            1.0,
            55,
            0,
            2,
            1
    ),

    GIANT_WAR_BAT(
            FlyingRole.FLYING_WARRIOR,
            "giant-war-bat/giant-war-bat",
            5,
            4.0,
            40.0,
            5.0,
            2.0,
            100,
            2,
            4,
            1
    ),

    FLYING_WAR_CERBERUS(
            FlyingRole.ELITE_FLYING_WARRIOR,
            "flying-war-cerberus/giant-war-cerberus",
            7,
            3.0,
            60.0,
            7.0,
            3.0,
            190,
            4,
            8,
            2
    );

    private final FlyingRole role;
    private final String imgUrl;
    private final String displayName;

    private final Integer strength;
    private final Double movementSpeed;

    private final Double baseHealth;
    private final Double baseDamage;
    private final Double baseDefense;

    private final Integer recruitmentGoldCost;
    private final Integer recruitmentMordorSteelCost;

    private final Integer foodUpkeep;
    private final Integer capacityCost;

    private final CreatureType creatureType = CreatureType.FLYING;
    private final CreatureMovementType movementType = CreatureMovementType.FLYING;

    FlyingRaceType(
            FlyingRole role,
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

        String baseImgUrl = "img/army/flying/";
        this.imgUrl = baseImgUrl + imgUrl + ".png";

        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
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