package com.mordor.backend.creature.domain.troll.enums;

import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;

public enum TrollRaceType implements CreatureTypeMapperInterface {

    CAVE_TROLL(
            TrollRole.BRUTE,
            "cave-troll/cave-troll",
            8,
            1.0,
            65.0,
            6.0,
            2.0,
            95,
            0,
            5,
            4
    ),

    MOUNTAIN_TROLL(
            TrollRole.HEAVY_BRUTE,
            "mountain-troll/mountain-troll",
            10,
            1.0,
            80.0,
            7.0,
            3.0,
            150,
            1,
            7,
            6
    ),

    OLOG_HAI(
            TrollRole.ELITE_BRUTE,
            "olog-hai/olog-hai",
            12,
            1.0,
            100.0,
            9.0,
            4.0,
            230,
            3,
            10,
            9
    );

    private final TrollRole role;
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

    private final CreatureType creatureType = CreatureType.TROLL;
    private final CreatureMovementType movementType = CreatureMovementType.GROUND;

    TrollRaceType(
            TrollRole role,
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

        String baseImgUrl = "img/army/troll/";
        this.imgUrl = baseImgUrl + imgUrl + ".png";

        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
    }

    public TrollRole getRole() {
        return role;
    }

    public String getTypeValue() {
        return this.name();
    }

    public String getTypeDisplayName() {
        return this.displayName;
    }

    public String getRoleValue() {
        return role.name();
    }

    public String getRoleDisplayName() {
        return role.getDisplayName();
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

    public String getCreatureTypeValue() {
        return creatureType.name();
    }

    public String getCreatureTypeDisplayName() {
        return creatureType.getDisplayName();
    }

    public CreatureMovementType getMovementType() {
        return movementType;
    }

    public String getMovementTypeValue() {
        return movementType.name();
    }

    public String getMovementTypeDisplayName() {
        return movementType.getDisplayName();
    }
}