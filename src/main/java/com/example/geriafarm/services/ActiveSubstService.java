package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActiveSubstService {

    ActiveSubst createActiveSubst (ActiveSubst activeSubst);
    List<ActiveSubst> findAllActiveSubst();
    ActiveSubst findActiveSubstById(Long activeSubstId);
    ActiveSubst update (ActiveSubst activeSubst);
    void delete (Long activeSubstId);
    List<ActiveSubst> findActiveSubstBySearchCode (String searchCode);
    List <ActiveSubst> findActiveSubstanceByName (String activeSubstName);
    List<ActiveSubst> findActiveSubstByMedicineId (Long medId);

}
