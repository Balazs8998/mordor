package com.mordor.backend.creature.dto.response;

import java.util.List;

public record EquipmentItemResponse(

        Long id,
        Long creatureId,
        String rightHand,
        String leftHand,
        List<String> weapons

) {
}
