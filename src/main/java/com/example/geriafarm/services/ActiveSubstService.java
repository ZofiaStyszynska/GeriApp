package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActiveSubstService {

    ActiveSubst createActiveSubst (ActiveSubst activeSubst);
    List<ActiveSubst> findAllActiveSubst();
    ActiveSubst findActiveSubstById(Long activeSubstId);
    ActiveSubst update (Long activeSubstId, ActiveSubst activeSubst);
    void delete (Long activeSubstId);
    List<ActiveSubst> findActiveSubstBySearchCode (String searchCode);
}
