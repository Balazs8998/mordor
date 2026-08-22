package com.mordor.backend.game.equipment;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.equipment.domain.HumanoidEquipment;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j

@Component
public class EquipmentRules {



    public void validateWeaponEnums(EquipmentItemRequest request) {


        if (request.leftHand() != null){
            try{
                WeaponType.valueOf(request.leftHand());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
        if (request.rightHand() != null){
            try {
                WeaponType.valueOf(request.rightHand());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
        if (request.weapons() != null) {
            try {
                request.weapons().forEach(WeaponType::valueOf);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void validateEquipmentSlots(EquipmentItemRequest request) {

        if (request.leftHand() != null && request.rightHand() != null){
            WeaponType leftHand = WeaponType.valueOf(request.leftHand());
            WeaponType rightHand = WeaponType.valueOf(request.rightHand());

            if(leftHand.getHandsRequired() > 1 || rightHand.getHandsRequired() > 1) {
                throw new RuntimeException("Invalid equipment slots: One of the weapons requires more than one hand.");
            }
        }

    }

    public double creatureHaveEnoughStrenght(Creature creature, EquipmentItemRequest request) {
        double strengthCost = 0;
        double creatureStrength = creature.getStrength();

        if (request.leftHand() != null){
            WeaponType leftHand = WeaponType.valueOf(request.leftHand());
            strengthCost += leftHand.getStrengthCost();
        }
        if (request.rightHand() != null){
            WeaponType rightHand = WeaponType.valueOf(request.rightHand());
            strengthCost += rightHand.getStrengthCost();
        }


        if (strengthCost > creatureStrength) {
            throw new RuntimeException("Creature does not have enough strength to equip the requested items.");
        }
        return strengthCost;
    }

    public List<WeaponType> findNewWeapons(Creature creature, EquipmentItemRequest request) {
        List<WeaponType> creatureWeaponPool = new ArrayList<>(creature.getEquipment().getWeapons());

        if (creature.getEquipment() instanceof HumanoidEquipment humanoidEquipment) {
            if (humanoidEquipment.getLeftHand() != null) {
                creatureWeaponPool.add(WeaponType.valueOf(humanoidEquipment.getLeftHand()));
            }
            if (humanoidEquipment.getRightHand() != null) {
                creatureWeaponPool.add(WeaponType.valueOf(humanoidEquipment.getRightHand()));
            }
        }

        List<WeaponType> requestWeaponPool =
                new ArrayList<>(
                        request.weapons().stream()
                                .map(WeaponType::valueOf)
                                .toList()
                );

        if (request.leftHand() != null) {
            requestWeaponPool.add(WeaponType.valueOf(request.leftHand()));
        }

        if (request.rightHand() != null) {
            requestWeaponPool.add(WeaponType.valueOf(request.rightHand()));
        }


        return findWeaponsToBuy(creatureWeaponPool, requestWeaponPool);
    }

    private List<WeaponType> findWeaponsToBuy(List<WeaponType> creatureWeaponPool, List<WeaponType> requestWeaponPool) {

        List<WeaponType> weaponsToBuy = new ArrayList<>();

        Iterator<WeaponType> iterator = requestWeaponPool.iterator();
        while (iterator.hasNext()) {
            WeaponType requestWeapon = iterator.next();
            if (!creatureWeaponPool.remove(requestWeapon)) {
                weaponsToBuy.add(requestWeapon);
            }
        }

        return weaponsToBuy;
    }


}
