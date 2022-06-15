package com.example.geriafarm.services;

import com.example.geriafarm.entities.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {


    Disease createDisease(Disease disease);
    List<Disease> findAllDiseases();
    Optional<Disease> findDiseaseById(Long diseaseId);
    Optional<Disease> findDiseaseByIcd10(String icd10Code);
    Disease updateDisease (Disease disease);
    void deleteDisease (Long icd10Id);

}
