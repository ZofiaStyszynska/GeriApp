package com.example.geriafarm.services.implementations;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.ICD10;
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
    public Interactions addInteraction(Interactions interactions) {

        return interactionsRepository.save(interactions);
    }

    @Override
    public List<String> findInteractions(List<String> ATCCodes, List<String> ICD10Codes) {
        List<String> listOfInteractions = new ArrayList<>();
        for (int i = 0; i < activeSubsts.size(); i++) {
            for (int j = 0; j < ICD10Codes.size(); j++) {
                if (interactionsRepository
                        .existsInteractionsByAtcCodesContainingAndICD10CodesContaining
                                (activeSubsts.get(i), ICD10Codes.get(j))) {
                    Interactions interactions = interactionsRepository
                            .findInteractionsByAtcCodesContainingAndICD10CodesContaining
                                    (activeSubsts.get(i), ICD10Codes.get(j));

                    listOfInteractions.add(interactions.getDescription());
                }
            }

        }


        return listOfInteractions;
    }


}
