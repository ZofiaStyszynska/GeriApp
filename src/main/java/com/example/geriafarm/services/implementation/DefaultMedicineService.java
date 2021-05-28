package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.MedicineDTO;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.repositories.MedicineRepository;
import com.example.geriafarm.services.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultMedicineService implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final ActiveSubstRepository activeSubstRepository;

    public DefaultMedicineService(MedicineRepository medicineRepository, ActiveSubstRepository activeSubstRepository) {
        this.medicineRepository = medicineRepository;
        this.activeSubstRepository = activeSubstRepository;
    }

    @Override
    public List<MedicineDTO> getMedicines() {
        return null;
    }

    @Override
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {
        return null;
    }

    @Override
    public MedicineDTO getMedicine(UUID id) {
        return null;
    }

    @Override
    public List<MedicineDTO> getMedicinesByActiveSubst(UUID activeSubstId) {
        return null;
    }

    @Override
    public MedicineDTO updateMedicine(UUID id, MedicineDTO medicineDTO) {
        return null;
    }

    @Override
    public void deleteMedicine(UUID id) {

    }
}
