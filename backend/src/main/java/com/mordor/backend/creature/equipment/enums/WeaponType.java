package com.mordor.backend.creature.equipment.enums;

import lombok.Getter;

@Getter

public enum WeaponType {

    DAGGER(
            CombatRange.MELEE,
            1,
            0,
            0,
            1,
            8,
            0,
            "icon/dagger.png",
            "dagger.png",
            "dagger.png",
            "dagger.png",
            ""

    ),

    ONE_HAND_SWORD(
            CombatRange.MELEE,
            2,
            1,
            0,
            2,
            18,
            1,
            "icon/sword.png",
            "one_hand_sword.png",
            "one_hand_sword.png",
            "one_hand_sword.png",
            ""

    ),

    MACE(
            CombatRange.MELEE,
            3,
            0,
            0,
            3,
            20,
            1,
            "icon/mace.png",
            "mace.png",
            "mace.png",
            "mace.png",
            ""

    ),

    SHIELD(
            CombatRange.MELEE,
            0,
            3,
            0,
            3,
            24,
            2,
            "icon/shield.png",
            "shield.png",
            "shield.png",
            "shield.png",
            ""

    ),

    SPEAR(
            CombatRange.MELEE,
            2,
            0,
            1,
            3,
            18,
            1,
            "icon/spear.png",
            "spear.png",
            "spear.png",
            "spear.png",
            ""

            ),

    BOW(
            CombatRange.RANGED,
            2,
            0,
            3,
            3,
            26,
            1,
            "icon/bow.png",
            "bow.png",
            "bow.png",
            "bow.png",
            ""
    ),

    LONG_SWORD(
            CombatRange.MELEE,
            3,
            1,
            0,
            5,
            34,
            2,
            "icon/sword.png",
            "long_sword.png",
            "",
            "",
            "long_sword.png"


    ),

    LONG_SPEAR(
            CombatRange.MELEE,
            3,
            0,
            2,
            5,
            30,
            2,
            "icon/spear.png",
            "long_spear.png",
            "",
            "",
            "long_spear.png"


    ),

    HEAVY_MACE(
            CombatRange.MELEE,
            5,
            0,
            0,
            6,
            36,
            3,
            "icon/mace.png",
            "heavy_mace.png",
            "",
            "",
            "heavy_mace.png"

            );

    private final CombatRange combatRange;
    private final Integer damageBonus;
    private final Integer defenseBonus;
    private final Integer range;
    private final Integer strengthCost;

    private final Integer goldCost;
    private final Integer mordorSteelCost;

    private final String displayName;

    private final String iconImgUrl;

    private final String imgUrl;

    private final String leftHandLayerImgUrl;

    private final String rightHandLayerImgUrl;

    private final String twoHandLayerImgUrl;

    WeaponType(
            CombatRange combatRange,
            Integer damageBonus,
            Integer defenseBonus,
            Integer range,
            Integer strengthCost,
            Integer goldCost,
            Integer mordorSteelCost, String iconImgUrl, String imgUrl, String leftHandLayerImgUrl, String rightHandLayerImgUrl, String twoHandLayerImgUrl
    ) {

        String baseImgUrl = "img/weapon/";
        String layerImgUrl = "layer/";

        this.iconImgUrl = baseImgUrl + iconImgUrl;
        this.imgUrl = baseImgUrl + imgUrl;
        this.leftHandLayerImgUrl = baseImgUrl + layerImgUrl + leftHandLayerImgUrl;
        this.rightHandLayerImgUrl = baseImgUrl + layerImgUrl + rightHandLayerImgUrl;
        this.twoHandLayerImgUrl = baseImgUrl + layerImgUrl + twoHandLayerImgUrl;

        this.combatRange = combatRange;
        this.damageBonus = damageBonus;
        this.defenseBonus = defenseBonus;
        this.range = range;
        this.strengthCost = strengthCost;

        this.goldCost = goldCost;
        this.mordorSteelCost = mordorSteelCost;


        String formatted = name()
                .replace("_", " ")
                .toLowerCase();

        this.displayName =
                formatted.substring(0, 1).toUpperCase()
                        + formatted.substring(1);
    }

}