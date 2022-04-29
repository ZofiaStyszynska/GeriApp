package com.example.geriafarm.services;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.ICD10;
import com.example.geriafarm.entities.Interactions;

import java.util.List;

public interface InteractionService {

    Interactions addInteraction(Interactions interactions);
    List <String> findInteractions(List<String> ATCCodes, List<String> ICD10Codes);
}
