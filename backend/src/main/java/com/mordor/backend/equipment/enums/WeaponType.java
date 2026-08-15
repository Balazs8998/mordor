package com.mordor.backend.equipment.enums;

public enum WeaponType {
    ONE_HAND_SWORD( CombatRange.MELEE, 2,2, 0),
    LONG_SWORD( CombatRange.MELEE, 5,1, 0),
    MACE( CombatRange.MELEE, 4,2, 0),
    HEAVY_MACE( CombatRange.MELEE, 7,2, 0),
    SPEAR( CombatRange.MELEE, 2,1, 0),
    LONG_SPEAR( CombatRange.MELEE, 4,1, 0),
    BOW( CombatRange.RANGED, 2,0, 2),
    SHIELD( CombatRange.MELEE, 0, 2, 0),
    KNIFE( CombatRange.MELEE, 1, 0,0);

    private final CombatRange combatRange;
    private final Integer damageBonus;
    private final Integer defenseBonus;
    private final Integer range;

     WeaponType (CombatRange combatRange, Integer damageBonus, Integer defenseBonus, Integer range) {
        this.combatRange = combatRange;
        this.damageBonus = damageBonus;
        this.defenseBonus = defenseBonus;
        this.range = range;
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
}
