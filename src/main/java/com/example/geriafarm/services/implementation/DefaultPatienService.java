package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.PatientDTO;
import com.example.geriafarm.repositories.MedicineRepository;
import com.example.geriafarm.repositories.PatientRepository;
import com.example.geriafarm.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultPatienService implements PatientService {

    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;

    public DefaultPatienService(PatientRepository patientRepository, MedicineRepository medicineRepository) {
        this.patientRepository = patientRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public PatientDTO getPatient(UUID id) {
        return null;
    }

    @Override
    public PatientDTO updatePatient(UUID id, PatientDTO patientDTO) {
        return null;
    }

    @Override
    public void deletePatient(UUID id) {

    }

    @Override
    public List<PatientDTO> getPatients() {
        return null;
    }
}
