package com.example.geriafarm.services;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActiveSubstService {

    List<ActiveSubstDTO> getSubstances();

    Long addSubstance(ActiveSubstDTO activeSubstDTO);

    Optional<ActiveSubstDTO> getSubstanceById(Long id);

    ActiveSubstDTO updateSubstance(Long id, ActiveSubstDTO activeSubstDTO);

    List<ActiveSubstDTO> getSubstancesByMedicine(Long medicineId);

    List<ActiveSubstDTO> getSubstancesByAnatomicalGroup(ATCdto atcDto);

    List<ActiveSubstDTO> getSubstancesByTherapeuticSubgroup(ATCdto atcDto);
}
