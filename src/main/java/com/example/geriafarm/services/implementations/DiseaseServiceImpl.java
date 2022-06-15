package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.Disease;
import com.example.geriafarm.exeptions.AlreadyInTheDBException;
import com.example.geriafarm.repositories.DiseaseRepository;
import com.example.geriafarm.services.DiseaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Disease createDisease(Disease disease) {
        boolean exists = diseaseRepository.existsDiseaseByICD10Equals(disease.getICD10());
        if(exists){
            throw new AlreadyInTheDBException("ICD10 Already exists in the DB");
        }
        return diseaseRepository.save(disease);
    }

    @Override
    public List<Disease> findAllDiseases() {
        return diseaseRepository.findAll();
    }

    @Override
    public Optional<Disease> findDiseaseById(Long diseaseId) {
        return diseaseRepository.findById(diseaseId);
    }

    @Override
    public Optional<Disease> findDiseaseByIcd10(String icd10Code) {
        return diseaseRepository.findDiseaseByICD10Equals(icd10Code);
    }

    @Override
    public Disease updateDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public void deleteDisease(Long icd10Id) {
        diseaseRepository.deleteById(icd10Id);

    }
}
