package com.mordor.backend.game.equipment;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.equipment.domain.Equipment;
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
        log.debug("Validation Weapon Enums: Left Hand - {}, Right Hand - {}", request.leftHand(), request.rightHand());


        if (request.leftHand() != null) {
            try {
                WeaponType.valueOf(request.leftHand());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
        if (request.rightHand() != null) {
            try {
                WeaponType.valueOf(request.rightHand());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void validateEquipmentSlots(EquipmentItemRequest request) {

        if (request.leftHand() != null && request.rightHand() != null) {
            WeaponType leftHand = WeaponType.valueOf(request.leftHand());
            WeaponType rightHand = WeaponType.valueOf(request.rightHand());

            log.debug("Left Hand: {}, Right Hand: {}", leftHand.getHandsRequired(), rightHand.getHandsRequired());

            if (leftHand.getHandsRequired() > 1 || rightHand.getHandsRequired() > 1) {
                throw new RuntimeException("Invalid equipment slots: One of the weapons requires more than one hand.");
            }
        }

    }

    public double creatureHaveEnoughStrenght(Creature creature, EquipmentItemRequest request) {
        double strengthCost = 0;
        double creatureStrength = creature.getStrength();

        if (request.leftHand() != null) {
            WeaponType leftHand = WeaponType.valueOf(request.leftHand());
            strengthCost += leftHand.getStrengthCost();
        }
        if (request.rightHand() != null) {
            WeaponType rightHand = WeaponType.valueOf(request.rightHand());
            strengthCost += rightHand.getStrengthCost();
        }

        log.debug("Strength Cost: {}", strengthCost);
        log.debug("Creature Strength: {}", creatureStrength);


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
                new ArrayList<>();

        if (request.leftHand() != null) {
            requestWeaponPool.add(WeaponType.valueOf(request.leftHand()));
        }

        if (request.rightHand() != null) {
            requestWeaponPool.add(WeaponType.valueOf(request.rightHand()));
        }

        log.debug("Creature Weapon Pool: {}", creatureWeaponPool);
        log.debug("New Weapons Pool: {}", requestWeaponPool);

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

        log.debug("Weapons to Buy: {}", weaponsToBuy);

        return weaponsToBuy;
    }


    public void applyWeaponEquipment(List<WeaponType> newWeapon,Creature creature, EquipmentItemRequest request) {
        List<WeaponType> pool = new ArrayList<>();
        Equipment equipment = creature.getEquipment();
        pool.addAll(equipment.getWeapons());
        pool.addAll(newWeapon);
        WeaponType requestLeftHand = request.leftHand() != null ? WeaponType.valueOf(request.leftHand()) : null;
        WeaponType requestRightHand = request.rightHand() != null ? WeaponType.valueOf(request.rightHand()) : null;


        log.debug("newWeapons: {}", newWeapon);
        log.debug("creature inventory: {}", equipment.getWeapons());
        log.debug("Request Left Hand: {}", requestLeftHand);
        log.debug("Request Right Hand: {}", requestRightHand);

        if (equipment instanceof HumanoidEquipment humanoidEquipment) {
            WeaponType creatureLeftHand = humanoidEquipment.getLeftHand()
                    != null ? WeaponType.valueOf(humanoidEquipment.getLeftHand()) : null;
            if(creatureLeftHand != null){
                pool.add(creatureLeftHand);
            }

            WeaponType creatureRightHand = humanoidEquipment.getRightHand()
                    != null ? WeaponType.valueOf(humanoidEquipment.getRightHand()) : null;
            if(creatureRightHand != null){
            pool.add(creatureRightHand);}

            log.debug("Pool: {}", pool);
            log.debug("Creature Left Hand: {}", creatureLeftHand);
            log.debug("Creature Right Hand: {}", creatureRightHand);

            WeaponType LeftHand = takeWeaponFromPool(pool, requestLeftHand);
            if(requestLeftHand != null && LeftHand == null){
                throw new RuntimeException("Weapon to equip not found in pool.");
            }
                humanoidEquipment.setLeftHand(LeftHand);

            WeaponType RightHand = takeWeaponFromPool(pool, requestRightHand);
            if(requestRightHand != null && RightHand == null){
                throw new RuntimeException("Weapon to equip not found in pool.");
            }
                humanoidEquipment.setRightHand(RightHand);
            log.debug("TakeWeapon Left Hand: {}", LeftHand);
            log.debug("TakeWeapon Right Hand: {}", RightHand);

            humanoidEquipment.setWeapons(pool);
            log.debug("pool after equip: {}", pool);
        }

        log.debug("Uneqipped Weapons: {}", creature.getEquipment().getWeapons());
    }

    private WeaponType takeWeaponFromPool(List<WeaponType> pool, WeaponType weapon) {
        Iterator<WeaponType> iterator = pool.iterator();
        while (iterator.hasNext()) {
            WeaponType w = iterator.next();
            if (w == weapon) {
                iterator.remove();
                return w;
            }
        }
        return null;
    }

}
