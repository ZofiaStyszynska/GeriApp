package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {

    List<Medicine> findAllMedicines();
    Optional<Medicine> findMedicineById(Long medId);
    Medicine createMedicine (Medicine medicine);
    Medicine updateMedicine (Medicine medicine);
    void deleteMedicine (Long medId);
    List<Medicine> findMedicinesContainingAS(Long asId);



}
