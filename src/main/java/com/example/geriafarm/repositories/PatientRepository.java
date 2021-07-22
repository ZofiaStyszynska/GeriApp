package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
