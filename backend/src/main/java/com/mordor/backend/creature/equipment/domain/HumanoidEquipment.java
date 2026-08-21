package com.mordor.backend.creature.equipment.domain;

import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class HumanoidEquipment extends Equipment {

    @Column
    @Enumerated(EnumType.STRING)
    private WeaponType rightHand;

    @Column
    @Enumerated(EnumType.STRING)
    private WeaponType leftHand;



    @Override
    public void equip(EquipmentSlots slot, WeaponType weaponType) {
        if (slot == EquipmentSlots.RIGHT_HAND) {
            if (super.getWeapons().remove(weaponType)) {
                if (rightHand != null) {
                    super.getWeapons().add(rightHand);
                }
                rightHand = weaponType;
            }
        } else if (slot == EquipmentSlots.LEFT_HAND) {
            if (super.getWeapons().remove(weaponType)) {
                if (leftHand != null) {
                    super.getWeapons().add(leftHand);
                }
                leftHand = weaponType;
            }
        }
    }

    @Override
    public void unequip(EquipmentSlots slot) {
        if (slot == EquipmentSlots.RIGHT_HAND) {
            if (rightHand != null) {
                super.getWeapons().add(rightHand);
                rightHand = null;
            }
        } else if (slot == EquipmentSlots.LEFT_HAND) {
            if (leftHand != null) {
                super.getWeapons().add(leftHand);
                leftHand = null;
            }
        }
    }

    @Override
    public String getLeftHand() {
        return leftHand != null ? leftHand.name() : null;
    }

    @Override
    public String getLeftHandIconImgUrl() {
        return leftHand != null ? leftHand.getIconImgUrl() : "";
    }

    @Override
    public String getLeftHandLayerImgUrl() {
        return leftHand != null ? leftHand.getLeftHandLayerImgUrl() : "";
    }

    @Override
    public String getRightHand() {
        return rightHand != null ? rightHand.name() : null;
    }

    @Override
    public String getRightHandIconImgUrl() {
        return rightHand != null ? rightHand.getIconImgUrl() : "";
    }

    @Override
    public String getRightHandLayerImgUrl() {
        return rightHand != null ? rightHand.getRightHandLayerImgUrl() : "";
    }

    @Override
    public void clearEquippedWeapons() {
        rightHand = null;
        leftHand = null;
    }
}
