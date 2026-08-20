package com.mordor.backend.creature.domain.flying.enums;

import com.mordor.backend.creature.domain.shared.CreatureTypeMapperInterface;
import com.mordor.backend.creature.enums.CreatureMovementType;
import com.mordor.backend.creature.enums.CreatureType;
import lombok.Getter;

@Getter
public enum FlyingRaceType implements CreatureTypeMapperInterface {

    GIANT_BAT(
            FlyingRole.FLYING_SCOUT,
            "giant-bat/giant-bat",

            3.0,
            10.0,
            2.0,

            25.0,
            4.0,
            1.0,

            30.0,
            4.0,

            55,
            0,

            2,
            2
    ),

    GIANT_WAR_BAT(
            FlyingRole.FLYING_WARRIOR,
            "giant-war-bat/giant-war-bat",

            5.0,
            8.0,
            3.0,

            40.0,
            5.0,
            2.0,

            55.0,
            4.0,

            100,
            2,

            4,
            3
    ),

    FLYING_WAR_CERBERUS(
            FlyingRole.ELITE_FLYING_WARRIOR,
            "flying-war-cerberus/giant-war-cerberus",

            7.0,
            6.0,
            5.0,

            60.0,
            7.0,
            3.0,

            85.0,
            3.0,

            190,
            4,

            8,
            6
    );


    private final FlyingRole role;

    private final String imgUrl;
    private final String displayName;


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
            CreatureType.FLYING;

    private final CreatureMovementType movementType =
            CreatureMovementType.FLYING;


    FlyingRaceType(
            FlyingRole role,
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
                "img/army/flying/";

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
