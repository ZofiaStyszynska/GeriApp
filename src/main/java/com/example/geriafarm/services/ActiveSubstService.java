package com.example.geriafarm.services;

import com.example.geriafarm.DTO.ActiveSubstDTO;

import java.util.List;
import java.util.UUID;

public interface ActiveSubstService {

    List<ActiveSubstDTO> getSubstances();
    ActiveSubstDTO addSubstance(ActiveSubstDTO activeSubstDTO);
    ActiveSubstDTO getSubstance(UUID id);
    ActiveSubstDTO updateSubstance(UUID id, ActiveSubstDTO activeSubstDTO);
    List <ActiveSubstDTO> getSubstancesByMedicine(UUID medicineId);
}
