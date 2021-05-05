package com.example.geriafarm.services;

import com.example.geriafarm.DTO.MedicineDTO;

import java.util.List;
import java.util.UUID;

public interface MedicineService {
    List <MedicineDTO> getMedicines();
    MedicineDTO addMedicine(MedicineDTO medicineDTO);
    MedicineDTO getMedicine(UUID id);
    List <MedicineDTO> getMedicinesByActiveSubst(UUID activeSubstId);
    MedicineDTO updateMedicine(UUID id, MedicineDTO medicineDTO);
    void deleteMedicine(UUID id);
}
