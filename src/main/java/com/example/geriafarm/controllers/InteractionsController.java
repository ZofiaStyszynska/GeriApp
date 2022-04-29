package com.example.geriafarm.controllers;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.ICD10;
import com.example.geriafarm.services.InteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/interaction")
public class InteractionsController {

    private final InteractionService interactionService;

    public InteractionsController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<String>> getInteractions(@RequestParam(value = "activeSubsts")List<ActiveSubst> activeSubsts,
                                                        @RequestParam(value = "ICD10Codes")List<ICD10> ICD10Codes){
        List<String> listOfInteractions = interactionService.findInteractions(activeSubsts, ICD10Codes);
        return new ResponseEntity<>(listOfInteractions, HttpStatus.OK);


    }





}
