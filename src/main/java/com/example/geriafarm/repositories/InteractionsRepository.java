package com.example.geriafarm.repositories;


import com.example.geriafarm.entities.Interactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionsRepository extends JpaRepository<Interactions, Long> {

    boolean existsInteractionsByAtcCodesEquals(String atcCode);

    boolean existsInteractionsByICD10CodesEquals(String icd10);

    boolean existsInteractionsByAtcCodesEqualsAndICD10CodesEquals(String actCode, String icd10code);
    boolean existsInteractionsByAtcCodesIsStartingWithAndICD10CodesIsStartingWith(String actCode, String icd10code);

    Interactions findInteractionsByAtcCodesEqualsAndICD10CodesEquals(String actCode, String icd10code);
    Interactions findInteractionsByAtcCodesIsStartingWithAndICD10CodesIsStartingWith(String actCode, String icd10code);

    Interactions findInteractionsById (Long id);

    List<Interactions> findAll();


}
