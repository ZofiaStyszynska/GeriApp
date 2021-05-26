package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultActiveSubstService implements ActiveSubstService {
    @Override
    public List<ActiveSubstDTO> getSubstances() {
        return null;
    }

    @Override
    public ActiveSubstDTO addSubstance(ActiveSubstDTO activeSubstDTO) {
        return null;
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
