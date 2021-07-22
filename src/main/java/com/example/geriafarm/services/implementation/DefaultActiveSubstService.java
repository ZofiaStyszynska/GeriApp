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
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DefaultActiveSubstService implements ActiveSubstService {

    private final ActiveSubstRepository activeSubstRepository;
    private final ATCRepository atcRepository;

    public DefaultActiveSubstService(ActiveSubstRepository activeSubstRepository, ATCRepository atcRepository) {
        this.activeSubstRepository = activeSubstRepository;
        this.atcRepository = atcRepository;
    }

    @Override
    public List<ActiveSubstDTO> getSubstances() { //podaje listę wszystkich aktywnych substancji
        final List<ActiveSubstDTO> activeSubstDTOs = activeSubstRepository.findAll()
                .stream().map(ActiveSubstDTO::fromActiveSubstEnt)
                .collect(Collectors.toList());
        return activeSubstDTOs;
    }

    public static ATC createATCEntity(ATCdto atcDto) { //metoda przepisuje dane z frontendu(ATCdto) do poszczególnych pól w bazie danych
        ATC atcEntity = new ATC();
        atcEntity.setAnatomicalGr(atcDto.getAtcDto().substring(0, 1));
        atcEntity.setTherapeutSubgr(atcDto.getAtcDto().substring(1, 3));
        atcEntity.setPharmacolSubgr(atcDto.getAtcDto().substring(3, 4));
        atcEntity.setChemicalSubgr(atcDto.getAtcDto().substring(4, 5));
        atcEntity.setChemicalSubst(atcDto.getAtcDto().substring(5));
        return atcEntity;
    }

    @Override
    public Long addSubstance(ActiveSubstDTO activeSubstDTO) {


        final ActiveSubst activeSubst = activeSubstRepository
                .saveAndFlush(new ActiveSubst(null, activeSubstDTO.getName(), createATCEntity(activeSubstDTO.getAtc())
                )

        );

        return activeSubst.getId();
    }

    @Override
    public Optional<ActiveSubstDTO> getSubstanceById(Long id) {
        return activeSubstRepository.findById(id).map(ActiveSubstDTO::fromActiveSubstEnt);

    }

    @Override
    public ActiveSubstDTO updateSubstance(Long id, ActiveSubstDTO activeSubstDTO) {
        return null;
    }

    @Override
    public List<ActiveSubstDTO> getSubstancesByMedicine(Long medicineId) {

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
