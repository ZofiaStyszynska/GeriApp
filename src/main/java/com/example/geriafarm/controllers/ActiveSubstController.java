package com.example.geriafarm.controllers;

import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.exceptions.GeriaException;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping("/activesubstances")
public class ActiveSubstController {

    private final ActiveSubstService activeSubstService;

    public ActiveSubstController(ActiveSubstService activeSubstService) {
        this.activeSubstService = activeSubstService;
    }

    @PostMapping
    public ResponseEntity<Void> addActiveSubst (@RequestBody ActiveSubstDTO activeSubstDTO) throws GeriaException, URISyntaxException {
        UUID activeSubstId = activeSubstService.addSubstance(activeSubstDTO);

        return ResponseEntity
                .created(new URI("/activesubstances/" + activeSubstId))
                .build();
    }


}
