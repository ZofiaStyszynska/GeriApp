package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    boolean existsDiseaseByICD10Equals(String icd10);
    Optional<Disease> findDiseaseByICD10Equals (String icd10);
}
