package com.example.geriafarm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SubstanceAlreadyExistsException extends GeriaException{
    public SubstanceAlreadyExistsException(String message) {
        super(message);
    }
}
