package com.example.geriafarm.controllers;


import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.exeptions.ActiveSubstNotFoundException;
import com.example.geriafarm.services.ActiveSubstService;
import com.example.geriafarm.services.implementations.ActiveSubstServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/activesubstance")
public class ActiveSubstController {

    private final ActiveSubstServiceImpl activeSubstService;

    public ActiveSubstController(ActiveSubstServiceImpl activeSubstService) {
        this.activeSubstService = activeSubstService;
    }

    @GetMapping
    public ResponseEntity<List<ActiveSubst>> getAllActiveSubst() {
        List<ActiveSubst> activeSubsts = activeSubstService.findAllActiveSubst();
        return new ResponseEntity<>(activeSubsts, HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ActiveSubst> getActiveSubstById(@PathVariable("id") Long id) {
        ActiveSubst activeSubst = activeSubstService.findActiveSubstById(id);
        return new ResponseEntity<>(activeSubst, HttpStatus.OK);

    }

    @GetMapping("/search/{searchcode}")
    public ResponseEntity<List<ActiveSubst>> getActiveSubstBySearchCode(@PathVariable("searchcode") String searchCode) {
        List<ActiveSubst> activeSubsts = activeSubstService.findActiveSubstBySearchCode(searchCode);
        if(activeSubsts.isEmpty()){
            throw new ActiveSubstNotFoundException("No substances found.");
        }
        return new ResponseEntity<>(activeSubsts, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ActiveSubst>> getActiveSubstByName(@PathVariable("name") String name) {
        List<ActiveSubst> activeSubsts = activeSubstService.findActiveSubstanceByName(name);
        return new ResponseEntity<>(activeSubsts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ActiveSubst> addActiveSubst(@RequestBody ActiveSubst activeSubst) {
        ActiveSubst newActiveSubst = activeSubstService.createActiveSubst(activeSubst);
        return new ResponseEntity<>(activeSubst, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ActiveSubst> updateActiveSubst(@RequestBody ActiveSubst activeSubst) {
        ActiveSubst dbActiveSubst = activeSubstService.update(activeSubst);
        return new ResponseEntity<>(dbActiveSubst, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActiveSubst(@PathVariable("id") Long id) {
        activeSubstService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

