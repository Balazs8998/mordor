package com.mordor.backend.equipment.enums;

public enum WeaponType {
    ONE_HAND_SWORD( CombatRange.MELEE, 2,2, 0, 3),
    LONG_SWORD( CombatRange.MELEE, 5,1, 0, 7),
    MACE( CombatRange.MELEE, 4,2, 0, 6),
    HEAVY_MACE( CombatRange.MELEE, 7,2, 0, 8),
    SPEAR( CombatRange.MELEE, 2,1, 0, 4),
    LONG_SPEAR( CombatRange.MELEE, 4,1, 0, 6),
    BOW( CombatRange.RANGED, 2,0, 2, 2),
    SHIELD( CombatRange.MELEE, 0, 2, 0, 5),
    KNIFE( CombatRange.MELEE, 1, 0,0, 1);

    private final CombatRange combatRange;
    private final Integer damageBonus;
    private final Integer defenseBonus;
    private final Integer range;
    private final Integer requiredStrength;
    private final String displayName;


     WeaponType (CombatRange combatRange, Integer damageBonus, Integer defenseBonus, Integer range, Integer requiredStrength) {
        this.combatRange = combatRange;
        this.damageBonus = damageBonus;
        this.defenseBonus = defenseBonus;
        this.range = range;
        String formatted = name().replace("_", " ").toLowerCase();
        this.displayName = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);

        this.requiredStrength = requiredStrength;
    }

    public String getDisplayName() {
        return displayName;
    }

    public CombatRange getCombatRange() {
        return combatRange;
    }

    public Integer getDamageBonus() {
        return damageBonus;
    }

    public Integer getDefenseBonus() {
        return defenseBonus;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getRequiredStrength() {
        return requiredStrength;
    }
}
