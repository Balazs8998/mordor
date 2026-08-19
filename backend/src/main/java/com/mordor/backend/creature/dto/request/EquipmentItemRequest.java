package com.mordor.backend.creature.dto.request;

import java.util.List;

public record EquipmentItemRequest(

        String rightHand,
        String leftHand,
        List<String> weapons


) {
}
