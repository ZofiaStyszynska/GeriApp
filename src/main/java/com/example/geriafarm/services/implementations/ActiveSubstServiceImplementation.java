package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.services.ActiveSubstService;

import java.util.List;

public class ActiveSubstServiceImplementation implements ActiveSubstService {

    private final ActiveSubstRepository activeSubstRepository;

    public ActiveSubstServiceImplementation(ActiveSubstRepository activeSubstRepository) {
        this.activeSubstRepository = activeSubstRepository;
    }

    @Override
    public ActiveSubst createActiveSubst(ActiveSubst activeSubst) {

        return activeSubstRepository.save(activeSubst);
    }

    @Override
    public List<ActiveSubst> listActiveSubst() {
        return null;
    }

    @Override
    public ActiveSubst getActiveSubstById(Long activeSubstId) {
        return null;
    }

    @Override
    public ActiveSubst update(Long activeSubstId) {
        return null;
    }

    @Override
    public Boolean delete(Long activeSubstId) {
        return null;
    }

    @Override
    public List<ActiveSubst> findActiveSubstBySearchCode(String searchCode) {
        return activeSubstRepository.findActiveSubstsByAtcCodeIsStartingWith(searchCode);
    }
}
