package com.example.geriafarm.exceptions;

public class GeriaExceptionFactory {

    public static GeriaException createSubstanceNotFoundException(String message){
        return new MedicineNotFoundException(message);
    }
    public static GeriaException createMedicineNotFoundException(String message){
        return new MedicineNotFoundException(message);
    }
    public static GeriaException createSubstAlreadyExistsException(String message){
        return new SubstanceAlreadyExistsException(message);
    }
}
