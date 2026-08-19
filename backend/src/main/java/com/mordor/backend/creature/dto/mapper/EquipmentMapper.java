package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.dto.response.EquipmentItemResponse;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class EquipmentMapper {

    public void updateEquipmentFromRequest(EquipmentItemRequest request, Equipment equipment){

        equipment.setWeapons(
                new ArrayList<>(
                        request.weapons().stream()
                                .map(WeaponType::valueOf)
                                .toList()
                )
        );

        equipment.equip(EquipmentSlots.LEFT_HAND, request.leftHand()
                != null ? WeaponType.valueOf(request.leftHand()) : null);

        equipment.equip(EquipmentSlots.RIGHT_HAND, request.rightHand()
                != null ? WeaponType.valueOf(request.rightHand()) : null);


    }

    public EquipmentItemResponse equipmentToEquipmentItemResponse(Equipment equipment){
        return new EquipmentItemResponse(

                equipment.getId(),
                equipment.getCreature().getId(),
                equipment.getRightHand()
                        != null ? equipment.getRightHand() : null,

                equipment.getLeftHand()
                        != null ? equipment.getLeftHand() : null,

                equipment.getWeapons().stream().map(WeaponType::getDisplayName).toList()
        );
    }

}
