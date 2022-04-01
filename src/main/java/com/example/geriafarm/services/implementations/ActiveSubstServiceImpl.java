package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.exeptions.ActiveSubstNotFoundException;
import com.example.geriafarm.exeptions.AlreadyInTheDBException;
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
        boolean exists = activeSubstRepository.existsByAtcCode(activeSubst.getAtcCode());

        if (exists) {
            throw new AlreadyInTheDBException("Active substance already exists in the DB");
        }

        return activeSubstRepository.save(activeSubst);
    }

    @Override
    public List<ActiveSubst> findAllActiveSubst() {

        return activeSubstRepository.findAll();
    }

    @Override
    public ActiveSubst findActiveSubstById(Long activeSubstId) {
        return activeSubstRepository.findById(activeSubstId)
                .orElseThrow(() -> new ActiveSubstNotFoundException("Active substance not found"));
    }

    @Override
    public ActiveSubst update(ActiveSubst activeSubst) {
        return activeSubstRepository.save(activeSubst);
    }

    @Override
    public void delete(Long activeSubstId) {
        boolean exists = activeSubstRepository.existsById(activeSubstId);
        if (!exists) {
            throw new ActiveSubstNotFoundException("Given active substance doesn't exist in the db.");
        }
        activeSubstRepository.deleteById(activeSubstId);
    }

    @Override
    public List<ActiveSubst> findActiveSubstBySearchCode(String searchCode) {
        return activeSubstRepository.findActiveSubstsByAtcCodeIsStartingWith(searchCode);
    }

    @Override
    public List<ActiveSubst> findActiveSubstanceByName(String activeSubstName) {
        boolean exists = activeSubstRepository.existsActiveSubstsByNameEquals(activeSubstName);
        if (!exists) {
            throw new ActiveSubstNotFoundException("Not found.");
        }
        return activeSubstRepository.findActiveSubstsByNameStartingWithOrderByName(activeSubstName);
    }

    @Override
    public List<ActiveSubst> findActiveSubstByMedicineId(Long medId) {
        return activeSubstRepository.findActiveSubstsByMedicineId(medId);

    }
}
