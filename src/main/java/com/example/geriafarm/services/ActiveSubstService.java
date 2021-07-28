package com.example.geriafarm.services;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.exceptions.GeriaException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActiveSubstService {

    List<ActiveSubstDTO> getSubstances();

    Long addSubstance(ActiveSubstDTO activeSubstDTO) throws GeriaException;

    Optional<ActiveSubstDTO> getSubstanceById(Long id);

    ActiveSubstDTO updateSubstance(Long id, ActiveSubstDTO activeSubstDTO);

    List<ActiveSubstDTO> getSubstancesByMedicine(Long medicineId);

    List<ActiveSubstDTO> getSubstancesByAnatomicalGroup(ATCdto atcDto);

    List<ActiveSubstDTO> getSubstancesByTherapeuticSubgroup(ATCdto atcDto);
}
