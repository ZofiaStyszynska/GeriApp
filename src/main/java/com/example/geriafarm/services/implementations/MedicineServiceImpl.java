package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.repositories.MedicineRepository;
import com.example.geriafarm.services.MedicineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public List<Medicine> findAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        return null;
    }

    @Override
    public void deleteMedicine(Long medId) {

    }


}
