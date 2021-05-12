package com.example.geriafarm.services;

import com.example.geriafarm.DTO.PatientDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO getPatient(UUID id);
    PatientDTO updatePatient(UUID id, PatientDTO patientDTO);
    void deletePatient(UUID id);
    List <PatientDTO> getPatients();
}
