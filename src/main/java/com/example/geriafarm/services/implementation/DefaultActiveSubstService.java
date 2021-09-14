package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.entities.ATC;
import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.exceptions.GeriaException;
import com.example.geriafarm.exceptions.GeriaExceptionFactory;
import com.example.geriafarm.exceptions.SubstanceAlreadyExistsException;
import com.example.geriafarm.repositories.ATCRepository;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultActiveSubstService implements ActiveSubstService {

    private final ActiveSubstRepository activeSubstRepository;
    private final ATCRepository atcRepository;
    private final String BETA_BLOCKER_CODE = "CO7";

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

    private static GeriaException getSubstAlreadyExistsExeption() {
        return GeriaExceptionFactory.createSubstAlreadyExistsException("ATC code already exists");
    }

    @Override
    public Long addSubstance(ActiveSubstDTO activeSubstDTO) throws SubstanceAlreadyExistsException {

        final ActiveSubst activeSubst = activeSubstRepository
                .saveAndFlush(new ActiveSubst(null, activeSubstDTO.getName(), activeSubstDTO.getAtcCode()
                        ) //TODO sprawdzić, czy to w ogóle ma sens

                );

        return activeSubst.getId();
    }

    @Override
    public Optional<ActiveSubstDTO> getSubstanceById(Long id) {
        return activeSubstRepository.findById(id).map(ActiveSubstDTO::fromActiveSubstEnt)
                ;

    }

    @Override
    public ActiveSubstDTO updateSubstance(Long id, ActiveSubstDTO activeSubstDTO) {
        return null;
    }

    @Override
    public ActiveSubstDTO getSubstanceByATC(ATCdto atcDto) {
        ATC atc = createATCEntity(atcDto);
//        return activeSubstRepository.findActiveSubstsByAtc_AnatomicalGrAndAtc_TherapeutSubgrAndAtc_PharmacolSubgr(atc.getAnatomicalGr(),
//                atc.getTherapeutSubgr(), atc.getPharmacolSubgr());
        return null; //TODO
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

    //Beta-blocker with werapamil or diltiazem (B/p.3 in STOPP & Start criteria)
    public String betaBlockerRisk1(List<ActiveSubstDTO> activeSubstDTOS) {
        String message = null;
        List<ActiveSubst> activeSubsts = activeSubstDTOS.stream()
                .map(activeSubstDTO -> activeSubstRepository.findActiveSubstsByNameEquals(activeSubstDTO.getName()))
                .collect(Collectors.toList());
        boolean isBBPresent = activeSubsts.stream().anyMatch(activeSubst -> activeSubst.getAtcCode().substring(0, 3).equals(BETA_BLOCKER_CODE));
        boolean isVerapamilPresent = activeSubsts.stream().anyMatch(activeSubst -> activeSubst.getAtcCode().substring(0, 5).equals("C08DA"));
        boolean isDiltiazemPresent = activeSubsts.stream().anyMatch(activeSubst -> activeSubst.getAtcCode().substring(0, 5).equals("C08DB"));
        if ((isBBPresent&&isVerapamilPresent) ||(isBBPresent&&isDiltiazemPresent)) {
            message = "Istnieje ryzyko bloku serca";
        }
    return message;
    }
}
