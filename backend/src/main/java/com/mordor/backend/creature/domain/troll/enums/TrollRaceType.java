package com.mordor.backend.creature.domain.troll.enums;

import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;
import lombok.Getter;

@Getter
public enum TrollRaceType implements CreatureTypeMapperInterface {

    CAVE_TROLL(
            TrollRole.BRUTE,
            "cave-troll/cave-troll",

            8.0,
            2.0,
            2.0,

            65.0,
            6.0,
            2.0,

            50.0,
            1.0,

            95,
            0,

            5,
            4
    ),

    MOUNTAIN_TROLL(
            TrollRole.HEAVY_BRUTE,
            "mountain-troll/mountain-troll",

            10.0,
            1.0,
            2.0,

            80.0,
            7.0,
            3.0,

            70.0,
            1.0,

            150,
            1,

            7,
            6
    ),

    OLOG_HAI(
            TrollRole.ELITE_BRUTE,
            "olog-hai/olog-hai",

            12.0,
            3.0,
            6.0,

            100.0,
            9.0,
            4.0,

            90.0,
            1.0,

            230,
            3,

            10,
            9
    );


    private final TrollRole role;

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


    private final CreatureType creatureType =
            CreatureType.TROLL;

    private final CreatureMovementType movementType =
            CreatureMovementType.GROUND;


    TrollRaceType(
            TrollRole role,
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

        this.recruitmentGoldCost =
                recruitmentGoldCost;

        this.recruitmentMordorSteelCost =
                recruitmentMordorSteelCost;

        this.foodUpkeep = foodUpkeep;
        this.capacityCost = capacityCost;


        String baseImgUrl =
                "img/army/troll/";

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

