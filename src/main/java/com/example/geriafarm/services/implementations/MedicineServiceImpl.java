package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.repositories.MedicineRepository;
import com.example.geriafarm.services.ActiveSubstService;
import com.example.geriafarm.services.MedicineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final ActiveSubstRepository activeSubstRepository;
    private final ActiveSubstService activeSubstService;

    public MedicineServiceImpl(MedicineRepository medicineRepository, ActiveSubstRepository activeSubstRepository, ActiveSubstService activeSubstService) {
        this.medicineRepository = medicineRepository;
        this.activeSubstRepository = activeSubstRepository;
        this.activeSubstService = activeSubstService;
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

            activeSubstAlreadyExists = activeSubstRepository.existsActiveSubstsByAtcCodeEquals(as.getAtcCode());
            if (!activeSubstAlreadyExists) {
                activeSubstRepository.save(as);
            } else {
                //Znajduje subst aktywną w bazie
                ActiveSubst actSubst = activeSubstRepository.findActiveSubstsByAtcCodeEquals(as.getAtcCode());
                //Znajduje przyporządkowane leki
                Set<Medicine> medicinesWithTheActiveSubst = actSubst.getMedicines();
                //Dodaje nowy lek do przyporządkowanych
                medicinesWithTheActiveSubst.add(medicine);
                //Ustawia nowy zestaw leków
                actSubst.setMedicines(medicinesWithTheActiveSubst);
                //Zapisuje do bazy
                medicineRepository.save(medicine);
                medicine.getActiveSubsts().add(actSubst);
                //activeSubstService.update(actSubst);
            }
        }

    }

    public boolean activeSubstAlereadyInDB(ActiveSubst activeSubst) {
        return activeSubstRepository.existsActiveSubstsByAtcCodeEquals(activeSubst.getAtcCode());
    }


    @Override
    public Medicine createMedicine(Medicine medicine) {

        return medicineRepository.save(createNewMedicine(medicine, null));

    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {

        Long medId = medicine.getMedId();

        return medicineRepository.save(createNewMedicine(medicine, medId));
    }

    private Medicine createNewMedicine(Medicine medicine, Long medId) {
        Medicine dbMedicine = new Medicine();
        dbMedicine.setMedId(medId);
        dbMedicine.setTradeName(medicine.getTradeName());
        dbMedicine.setDosages(medicine.getDosages());
        Set<ActiveSubst> activeSubstInDBMedicine = new HashSet<>();

        Set<ActiveSubst> actSubstInAMedicine = medicine.getActiveSubsts();
        for (ActiveSubst as : actSubstInAMedicine) {
            if (!activeSubstAlereadyInDB(as)) {
                activeSubstRepository.save(as);
            }
            as = activeSubstRepository.findActiveSubstsByAtcCodeEquals(as.getAtcCode());
            activeSubstInDBMedicine.add(as);
        }

        dbMedicine.setActiveSubsts(activeSubstInDBMedicine);
        return dbMedicine;
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
