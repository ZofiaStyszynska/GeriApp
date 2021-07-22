package com.example.geriafarm.controllers;

import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.exceptions.GeriaException;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/activesubstances")
public class ActiveSubstController {

    private final ActiveSubstService activeSubstService;

    public ActiveSubstController(ActiveSubstService activeSubstService) {
        this.activeSubstService = activeSubstService;
    }

    @PostMapping
    public ResponseEntity<ActiveSubstDTO> addActiveSubst (@RequestBody ActiveSubstDTO activeSubstDTO) throws GeriaException, URISyntaxException {
        Long activeSubstId = activeSubstService.addSubstance(activeSubstDTO);

        return ResponseEntity
                .created(new URI("/activesubstances/" + activeSubstId))
                .body(activeSubstDTO);

    }
    @GetMapping
    public List <ActiveSubstDTO> getActiveSubsts(){
    return activeSubstService.getSubstances();
    };


}
