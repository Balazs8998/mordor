package com.mordor.backend.creature.domain.orc.enums;

import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;

public enum OrcRaceType implements CreatureTypeMapperInterface {

    SNAGA(
            OrcRole.SLAVE,
            "snaga/snaga",
            4,
            2.0,
            30.0,
            3.0,
            1.0,
            30,
            0,
            1,
            1
    ),

    URUK(
            OrcRole.WARRIOR,
            "uruk/uruk",
            6,
            2.0,
            40.0,
            4.0,
            2.0,
            55,
            1,
            2,
            2
    ),

    MOUNTAIN_ORC(
            OrcRole.HEAVY_WARRIOR,
            "mountain-orc/mountain-orc",
            8,
            2.0,
            50.0,
            5.0,
            3.0,
            85,
            2,
            3,
            3
    ),

    URUK_HAI(
            OrcRole.ELITE_WARRIOR,
            "uruk-hai/uruk-hai",
            10,
            2.0,
            60.0,
            6.0,
            4.0,
            125,
            3,
            4,
            4
    );

    private final OrcRole role;
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

    private final CreatureType creatureType = CreatureType.ORC;
    private final CreatureMovementType movementType = CreatureMovementType.GROUND;

    OrcRaceType(
            OrcRole role,
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

        String baseImgUrl = "img/army/orc/";
        this.imgUrl = baseImgUrl + imgUrl + ".png";

        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
    }

    public OrcRole getRole() {
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
