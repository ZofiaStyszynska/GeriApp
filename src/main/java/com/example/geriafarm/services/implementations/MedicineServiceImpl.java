package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.repositories.MedicineRepository;
import com.example.geriafarm.services.MedicineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final ActiveSubstRepository activeSubstRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository, ActiveSubstRepository activeSubstRepository) {
        this.medicineRepository = medicineRepository;
        this.activeSubstRepository = activeSubstRepository;
    }

    @Override
    public List<Medicine> findAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> findMedicineById(Long medId) {
        return medicineRepository.findById(medId);
    }

    //saves Active Substance if it's not in the repo
    public void saveActiveSubstIfNotInDB(Medicine medicine) {
        Set<ActiveSubst> actSubstInAMedicine = medicine.getActiveSubsts();
        boolean activeSubstAlreadyExists;
        for (ActiveSubst as : actSubstInAMedicine) {

            activeSubstAlreadyExists = activeSubstRepository.existsActiveSubstsByNameEquals(as.getAtcCode());
            if (!activeSubstAlreadyExists) activeSubstRepository.save(as);

        }

    }

    @Override
    public Medicine createMedicine(Medicine medicine) {

        saveActiveSubstIfNotInDB(medicine);

        return medicineRepository.save(medicine);

    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        Set<ActiveSubst> activeSubsts = medicine.getActiveSubsts();
        for (ActiveSubst as : activeSubsts) {
            activeSubstRepository.save(as);
        }

        return medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicine(Long medId) {
        medicineRepository.deleteById(medId);

    }

    @Override
    public List<Medicine> findMedicinesContainingAS(Long asId) {
        ActiveSubst as = activeSubstRepository.findById(asId).orElse(null);
        return medicineRepository.findMedicinesByActiveSubstsContaining(as);
    }


}
