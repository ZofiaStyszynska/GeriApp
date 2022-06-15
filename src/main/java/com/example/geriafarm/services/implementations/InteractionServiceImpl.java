package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.Interactions;
import com.example.geriafarm.repositories.InteractionsRepository;
import com.example.geriafarm.services.InteractionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InteractionServiceImpl implements InteractionService {

    private final InteractionsRepository interactionsRepository;

    public InteractionServiceImpl(InteractionsRepository interactionsRepository) {
        this.interactionsRepository = interactionsRepository;
    }

    @Override
    public List<Interactions> findAllInteractions() {
        return interactionsRepository.findAll();
    }


    @Override
    public Interactions addInteraction(Interactions interactions) {

        return interactionsRepository.save(interactions);
    }

    @Override
    public List<String> findInteractions(List<String> atcCodes, List<String> icd10Codes) {
        List<String> listOfInteractions = new ArrayList<>();


        for (int i = 0; i < atcCodes.size(); i++) {
            for (int j = 0; j < icd10Codes.size(); j++) {


                if (interactionsRepository.existsInteractionsByAtcCodesEqualsAndICD10CodesEquals
                        (atcCodes.get(i), icd10Codes.get(j))) {
                    Interactions interactions = interactionsRepository.findInteractionsByAtcCodesEqualsAndICD10CodesEquals
                            (atcCodes.get(i), icd10Codes.get(j));

                    listOfInteractions.add(interactions.getDescription());

                }
            }

        }


        return listOfInteractions;
    }


}
