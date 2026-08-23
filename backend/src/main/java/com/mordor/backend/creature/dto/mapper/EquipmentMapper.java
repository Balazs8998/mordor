package com.mordor.backend.creature.dto.mapper;

import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.dto.response.EquipmentItemResponse;
import com.mordor.backend.creature.equipment.domain.BeastEquipment;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.creature.equipment.domain.HumanoidEquipment;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class EquipmentMapper {

    public void updatedCommonEquipment(EquipmentItemRequest request, Equipment equipment){

        equipment.setWeapons(
                new ArrayList<>(
                        request.weapons().stream()
                                .map(WeaponType::valueOf)
                                .toList()
                )
        );

        if (equipment instanceof HumanoidEquipment humanoidEquipment) {
            updateHumanoidEquipmentFromRequest(request, humanoidEquipment);
        } else if (equipment instanceof BeastEquipment beastEquipment) {
            updateBeastEquipmentFromRequest(request, beastEquipment);
        }


    }

    private void updateBeastEquipmentFromRequest(EquipmentItemRequest request, BeastEquipment equipment){
        // TODO - v2 armors
    }

    private void updateHumanoidEquipmentFromRequest(EquipmentItemRequest request, HumanoidEquipment equipment) {


        equipment.setLeftHand(request.leftHand()
                != null ? WeaponType.valueOf(request.leftHand()) : null);
        equipment.setRightHand(request.rightHand()
                != null ? WeaponType.valueOf(request.rightHand()) : null);

    }

    public EquipmentItemResponse beastEquipmentToEquipmentItemResponse(BeastEquipment equipment){
        return new EquipmentItemResponse(

                equipment.getId(),
                equipment.getCreature().getId(),
                null,
                null,
                null,
                null,
                null,
                null,
                equipment.getWeapons().stream().map(WeaponType::name).toList()
        );
    }

    public EquipmentItemResponse humanoidEquipmentToEquipmentItemResponse(HumanoidEquipment humanoidEquipment){

        return new EquipmentItemResponse(

                humanoidEquipment.getId(),
                humanoidEquipment.getCreature().getId(),
                humanoidEquipment.getRightHand()
                        != null ? humanoidEquipment.getRightHand() : null,
                humanoidEquipment.getRightHandIconImgUrl()
                        != null ? humanoidEquipment.getRightHandIconImgUrl() : null,
                humanoidEquipment.getRightHandLayerImgUrl()
                        != null ? humanoidEquipment.getRightHandLayerImgUrl() : null,

                humanoidEquipment.getLeftHand()
                        != null ? humanoidEquipment.getLeftHand() : null,
                humanoidEquipment.getLeftHandIconImgUrl()
                        != null ? humanoidEquipment.getLeftHandIconImgUrl() : null,
                humanoidEquipment.getLeftHandLayerImgUrl()
                        != null ? humanoidEquipment.getLeftHandLayerImgUrl() : null,

                humanoidEquipment.getWeapons().stream().map(WeaponType::name).toList()
        );
    }

}
