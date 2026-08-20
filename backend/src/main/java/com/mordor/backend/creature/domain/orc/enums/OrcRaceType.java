package com.mordor.backend.creature.domain.orc.enums;

import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;
import lombok.Getter;

@Getter
public enum OrcRaceType implements CreatureTypeMapperInterface {

    SNAGA(
            OrcRole.SLAVE,
            "snaga/snaga",

            4.0,
            6.0,
            3.0,

            30.0,
            3.0,
            1.0,

            25.0,
            2.0,

            30,
            0,

            1,
            1
    ),

    URUK(
            OrcRole.WARRIOR,
            "uruk/uruk",

            6.0,
            5.0,
            4.0,

            40.0,
            4.0,
            2.0,

            55.0,
            2.0,

            55,
            1,

            2,
            2
    ),

    MOUNTAIN_ORC(
            OrcRole.HEAVY_WARRIOR,
            "mountain-orc/mountain-orc",

            8.0,
            3.0,
            3.0,

            50.0,
            5.0,
            3.0,

            75.0,
            2.0,

            85,
            2,

            3,
            3
    ),

    URUK_HAI(
            OrcRole.ELITE_WARRIOR,
            "uruk-hai/uruk-hai",

            10.0,
            6.0,
            6.0,

            60.0,
            6.0,
            4.0,

            90.0,
            2.0,

            125,
            3,

            4,
            4
    );


    private final OrcRole role;

    private final String displayName;
    private final String imgUrl;


    /*
     * ATTRIBUTES
     */

    private final Double strength;
    private final Double agility;
    private final Double intelligence;


    /*
     * COMBAT STATS
     */

    private final Double baseHealth;
    private final Double baseDamage;
    private final Double baseDefense;

    private final Double morale;


    /*
     * MOVEMENT
     */

    private final Double movementSpeed;


    /*
     * RECRUITMENT COST
     */

    private final Integer recruitmentGoldCost;
    private final Integer recruitmentMordorSteelCost;


    /*
     * UPKEEP / CAPACITY
     */

    private final Integer foodUpkeep;
    private final Integer capacityCost;


    private final CreatureType creatureType = CreatureType.ORC;

    private final CreatureMovementType movementType =
            CreatureMovementType.GROUND;


    OrcRaceType(
            OrcRole role,
            String imgUrl,

            Double strength,
            Double agility,
            Double intelligence,

            Double baseHealth,
            Double baseDamage,
            Double baseDefense,

            Double morale,
            Double movementSpeed,

            Integer recruitmentGoldCost,
            Integer recruitmentMordorSteelCost,

            Integer foodUpkeep,
            Integer capacityCost
    ) {

        this.role = role;

        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseDefense = baseDefense;

        this.morale = morale;
        this.movementSpeed = movementSpeed;

        this.recruitmentGoldCost = recruitmentGoldCost;
        this.recruitmentMordorSteelCost =
                recruitmentMordorSteelCost;

        this.foodUpkeep = foodUpkeep;
        this.capacityCost = capacityCost;


        String baseImgUrl = "img/army/orc/";

        this.imgUrl =
                baseImgUrl
                        + imgUrl
                        + ".png";


        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
    }


    public String getTypeValue() {
        return name();
    }


    public String getTypeDisplayName() {
        return displayName;
    }


    public String getRoleValue() {
        return role.name();
    }


    public String getRoleDisplayName() {
        return role.getDisplayName();
    }


    public String getCreatureTypeValue() {
        return creatureType.name();
    }


    public String getCreatureTypeDisplayName() {
        return creatureType.getDisplayName();
    }


    public String getMovementTypeValue() {
        return movementType.name();
    }


    public String getMovementTypeDisplayName() {
        return movementType.getDisplayName();
    }
}
