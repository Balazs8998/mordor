package com.mordor.backend.orc.dto.response;

import java.util.List;

public record OrcItemResponse(
        Long id,
        String name,
        String race,
        List<String> weapons,
        Integer kills
) {
}
