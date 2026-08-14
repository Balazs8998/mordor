package com.mordor.backend.core.exception;

import lombok.Getter;

@Getter

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String messageCode){
        super(messageCode);
    }

    public String getMessageCode(){
        return getMessage();
    }

}
