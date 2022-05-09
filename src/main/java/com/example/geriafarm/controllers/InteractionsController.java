package com.example.geriafarm.controllers;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.ICD10;
import com.example.geriafarm.entities.Interactions;
import com.example.geriafarm.services.InteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/interactions")
public class InteractionsController {

    private final InteractionService interactionService;

    public InteractionsController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Interactions>> getAllInteractions(){
        List<Interactions> allInteractions = interactionService.findAllInteractions();
        return new ResponseEntity<>(allInteractions,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<String>> getInteractions(@RequestParam(required=false, value= "atcCodes")List<String> atcCodes,
                                                        @RequestParam(required=false, value= "icd10Codes")List<String> icd10Codes){
        List<String> listOfInteractions = interactionService.findInteractions(atcCodes, icd10Codes);
        return new ResponseEntity<>(listOfInteractions, HttpStatus.OK);


    }

    @PostMapping("/add")
    public ResponseEntity<Interactions> createInteraction(@RequestBody Interactions interaction){
        Interactions newInteraction = interactionService.addInteraction(interaction);
        return new ResponseEntity<>(newInteraction, HttpStatus.OK);
    }





}
