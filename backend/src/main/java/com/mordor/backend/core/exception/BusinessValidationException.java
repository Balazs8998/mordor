package com.mordor.backend.core.exception;

import lombok.Getter;

@Getter
public class BusinessValidationException extends RuntimeException {

    private final String field;

    public BusinessValidationException(String field, String messageCode ) {
        super(messageCode);
        this.field = field;
    }
    public String getMessageCode() {
        return getMessage();
    }
}
