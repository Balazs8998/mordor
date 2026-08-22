package com.mordor.backend.creature.equipment.domain;

import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidEquipmentTest {

    private HumanoidEquipment equipment;

    @BeforeEach
    void setUp() {
        equipment = new HumanoidEquipment();
        equipment.setWeapons(new ArrayList<>());
    }

    @Test
    void equipShouldEquipWeaponToRightHand() {
        // Arrange
        equipment.getWeapons().add(WeaponType.DAGGER);

        // Act
        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.DAGGER
        );

        // Assert
        assertEquals("DAGGER", equipment.getRightHand());
        assertFalse(equipment.getWeapons().contains(WeaponType.DAGGER));
    }

    @Test
    void equipShouldEquipWeaponToLeftHand() {
        // Arrange
        equipment.getWeapons().add(WeaponType.MACE);

        // Act
        equipment.equip(
                EquipmentSlots.LEFT_HAND,
                WeaponType.MACE
        );

        // Assert
        assertEquals("MACE", equipment.getLeftHand());
        assertFalse(equipment.getWeapons().contains(WeaponType.MACE));
    }

    @Test
    void equipShouldReturnOldRightHandWeaponToWeaponsWhenReplacingWeapon() {
        // Arrange
        equipment.getWeapons().add(WeaponType.DAGGER);

        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.DAGGER
        );

        equipment.getWeapons().add(WeaponType.MACE);

        // Act
        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.MACE
        );

        // Assert
        assertEquals("MACE", equipment.getRightHand());

        assertTrue(
                equipment.getWeapons().contains(WeaponType.DAGGER)
        );

        assertFalse(
                equipment.getWeapons().contains(WeaponType.MACE)
        );
    }

    @Test
    void equipShouldReturnOldLeftHandWeaponToWeaponsWhenReplacingWeapon() {
        // Arrange
        equipment.getWeapons().add(WeaponType.DAGGER);

        equipment.equip(
                EquipmentSlots.LEFT_HAND,
                WeaponType.DAGGER
        );

        equipment.getWeapons().add(WeaponType.ONE_HAND_SWORD);

        // Act
        equipment.equip(
                EquipmentSlots.LEFT_HAND,
                WeaponType.ONE_HAND_SWORD
        );

        // Assert
        assertEquals("ONE_HAND_SWORD", equipment.getLeftHand());

        assertTrue(
                equipment.getWeapons().contains(WeaponType.DAGGER)
        );

        assertFalse(
                equipment.getWeapons().contains(WeaponType.ONE_HAND_SWORD)
        );
    }

    @Test
    void equipShouldNotEquipWeaponWhenWeaponIsNotInWeapons() {
        // Act
        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.DAGGER
        );

        // Assert
        assertNull(equipment.getRightHand());
        assertTrue(equipment.getWeapons().isEmpty());
    }

    @Test
    void equipShouldNotReplaceCurrentWeaponWhenNewWeaponIsNotInWeapons() {
        // Arrange
        equipment.getWeapons().add(WeaponType.DAGGER);

        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.DAGGER
        );

        // MACE nincs a weapons listában

        // Act
        equipment.equip(
                EquipmentSlots.RIGHT_HAND,
                WeaponType.MACE
        );

        // Assert
        assertEquals("DAGGER", equipment.getRightHand());

        assertFalse(
                equipment.getWeapons().contains(WeaponType.MACE)
        );
    }
}