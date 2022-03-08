package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> findAllMedicines();
    Medicine createMedicine (Medicine medicine);
    Medicine updateMedicine (Medicine medicine);
    void deleteMedicine (Long medId);



}
