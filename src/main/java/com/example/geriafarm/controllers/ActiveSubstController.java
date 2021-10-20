package com.example.geriafarm.controllers;

import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.exceptions.SubstanceAlreadyExistsException;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

//@RestController
//@RequestMapping("/activesubstances")
public class ActiveSubstController {

    private final ActiveSubstService activeSubstService;

    public ActiveSubstController(ActiveSubstService activeSubstService) {
        this.activeSubstService = activeSubstService;
    }

    @PostMapping
    public ResponseEntity addActiveSubst(@RequestBody ActiveSubstDTO activeSubstDTO) throws SubstanceAlreadyExistsException, URISyntaxException, SQLIntegrityConstraintViolationException {

        Long activeSubstId = activeSubstService.addSubstance(activeSubstDTO);

        ResponseEntity responseEntity = ResponseEntity
                .created(new URI("/activesubstances/" + activeSubstId))
                .body(activeSubstDTO);

        return responseEntity;

    }


    @GetMapping
    public List<ActiveSubstDTO> getActiveSubsts() {
        return activeSubstService.getSubstances();
    }

    ;


}
