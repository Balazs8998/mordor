package com.mordor.backend.creature.equipment.domain;

import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.equipment.enums.WeaponType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class BeastEquipment extends Equipment {


    @Override
    public void equip(EquipmentSlots slot, WeaponType weaponType) {

    }

    @Override
    public void unequip(EquipmentSlots slot) {

    }

    @Override
    public String getLeftHand() {
        return "";
    }

    @Override
    public String getRightHand() {
        return "";
    }

    @Override
    public void clearEquippedWeapons() {

    }
}
