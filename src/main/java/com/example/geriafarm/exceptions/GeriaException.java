package com.example.geriafarm.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice
public class GeriaException extends Exception {

    public GeriaException (String message) {super(message);}
}
