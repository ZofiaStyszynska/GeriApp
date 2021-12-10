package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.exeptions.ActiveSubstNotFoundExeption;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ActiveSubstServiceImpl implements ActiveSubstService {

    private final ActiveSubstRepository activeSubstRepository;

    public ActiveSubstServiceImpl(ActiveSubstRepository activeSubstRepository) {
        this.activeSubstRepository = activeSubstRepository;
    }

    @Override
    public ActiveSubst createActiveSubst(ActiveSubst activeSubst) {

        return activeSubstRepository.save(activeSubst);
    }

    @Override
    public List<ActiveSubst> findAllActiveSubst() {

        return activeSubstRepository.findAll();
    }

    @Override
    public ActiveSubst findActiveSubstById(Long activeSubstId) {
        return activeSubstRepository.findById(activeSubstId)
                .orElseThrow(()-> new ActiveSubstNotFoundExeption("Active substance not found"));
    }

    @Override
    public ActiveSubst update(Long activeSubstId, ActiveSubst activeSubst) {
        ActiveSubst dbActiveSubst = activeSubstRepository.findById(activeSubstId)
                .orElseThrow(()-> new ActiveSubstNotFoundExeption("Given active substance doesn't exist in the db."));
        dbActiveSubst.setAtcCode(activeSubst.getAtcCode());
        dbActiveSubst.setName(activeSubst.getName());
        return activeSubstRepository.save(activeSubst);
    }

    @Override
    public void delete(Long activeSubstId) {
        boolean exists = activeSubstRepository.existsById(activeSubstId);
        if (!exists){
            throw new ActiveSubstNotFoundExeption("Given active substance doesn't exist in the db.");
        }
        activeSubstRepository.deleteById(activeSubstId);
    }

    @Override
    public List<ActiveSubst> findActiveSubstBySearchCode(String searchCode) {
        return activeSubstRepository.findActiveSubstsByAtcCodeIsStartingWith(searchCode);
    }
}
