package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.entities.ATC;
import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.repositories.ATCRepository;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultActiveSubstService implements ActiveSubstService {

    private final ActiveSubstRepository activeSubstRepository;
    private final ATCRepository atcRepository;

    public DefaultActiveSubstService(ActiveSubstRepository activeSubstRepository, ATCRepository atcRepository) {
        this.activeSubstRepository = activeSubstRepository;
        this.atcRepository = atcRepository;
    }

    @Override
    public List<ActiveSubstDTO> getSubstances() {
        return null;
    }

    @Override
    public UUID addSubstance(ActiveSubstDTO activeSubstDTO) {
        ATC atc = new ATC();
        atc.setAnatomicalGr(activeSubstDTO.getAtc().getAnatomicalGr());
        final ActiveSubst activeSubst = activeSubstRepository.saveAndFlush(new ActiveSubst(null,
                activeSubstDTO.getName(),
                new ATC(null, activeSubstDTO.getAtc().getAnatomicalGr(),
                        activeSubstDTO.getAtc().getTherapeutSubgr(),
                        activeSubstDTO.getAtc().getPharmacolSubgr(),
                        activeSubstDTO.getAtc().getChemicalSubgr(),
                        activeSubstDTO.getAtc().getChemicalSubst()))
                );

        return activeSubst.getId();
    }

    @Override
    public ActiveSubstDTO getSubstance(UUID id) {
        return null;
    }

    @Override
    public ActiveSubstDTO updateSubstance(UUID id, ActiveSubstDTO activeSubstDTO) {
        return null;
    }

    @Override
    public List<ActiveSubstDTO> getSubstancesByMedicine(UUID medicineId) {
        return null;
    }

    @Override
    public List<ActiveSubstDTO> getSubstancesByAnatomicalGroup(ATCdto atcDto) {
        return null;
    }

    @Override
    public List<ActiveSubstDTO> getSubstancesByTherapeuticSubgroup(ATCdto atcDto) {
        return null;
    }
}
