package com.mordor.backend.creature.dto.response;

public record CreatureTypeItemResponse(
        String value,
        String displayName,
        String roleValue,
        String roleDisplayName,
        String imgUrl
) {
}
