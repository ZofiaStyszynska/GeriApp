package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveSubstService {

    ActiveSubst createActiveSubst (ActiveSubst activeSubst);
    List<ActiveSubst> listActiveSubst ();
    ActiveSubst getActiveSubstById(Long activeSubstId);
    ActiveSubst update (Long activeSubstId);
    Boolean delete (Long activeSubstId);
    List<ActiveSubst> findActiveSubstBySearchCode (String searchCode);
}
