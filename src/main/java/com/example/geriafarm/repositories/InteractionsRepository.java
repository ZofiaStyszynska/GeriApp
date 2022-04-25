package com.example.geriafarm.repositories;


import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.ICD10;
import com.example.geriafarm.entities.Interactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface InteractionsRepository  extends JpaRepository<Interactions, Long> {

   boolean existsInteractionsByAtcCodesContainingAndICD10CodesContaining (ActiveSubst actCode, ICD10 icd10);
   Interactions findInteractionsByAtcCodesContainingAndICD10CodesContaining (ActiveSubst actCode, ICD10 icd10);

}
