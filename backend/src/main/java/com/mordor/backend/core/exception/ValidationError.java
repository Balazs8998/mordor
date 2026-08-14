package com.mordor.backend.core.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError {

    private final List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public void addFieldError(String field, String message) {
        fieldErrors.add(new FieldErrorDTO(field, message));
    }

    public record FieldErrorDTO(
            String field,
            String message
    ) {
    }
}