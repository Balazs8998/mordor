package com.mordor.backend.creature.dto.response;

import java.util.List;

public record EquipmentItemResponse(

        Long id,
        Long creatureId,
        String rightHand,
        String rightHandIconImgUrl,
        String rightHandLayerImgUrl,
        String leftHand,
        String leftHandIconImgUrl,
        String leftHandLayerImgUrl,
        List<String> weapons

) {
}
