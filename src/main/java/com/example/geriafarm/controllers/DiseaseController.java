package com.example.geriafarm.controllers;

import com.example.geriafarm.entities.Disease;
import com.example.geriafarm.services.DiseaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/disease")

public class DiseaseController {
    private final DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }
    @PostMapping("/add")
    public ResponseEntity<Disease> addDisease(@RequestBody Disease disease){
        Disease newDisease = diseaseService.createDisease(disease);
        return new ResponseEntity<>(newDisease, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Disease>> getAllDiseases(){
        List<Disease> diseases = diseaseService.findAllDiseases();
        return new ResponseEntity<>(diseases,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Disease>> getDiseaseById(@PathVariable("id") Long id){
       Optional<Disease> disease = diseaseService.findDiseaseById(id);
        return new ResponseEntity<>(disease, HttpStatus.OK);
    }
    @GetMapping("/icd10/{icd10}")
    public ResponseEntity<Optional<Disease>> getDiseaseByIcd10(@PathVariable("icd10") String icd10Code){
        Optional<Disease> disease = diseaseService.findDiseaseByIcd10(icd10Code);
        return  new ResponseEntity<>(disease,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Disease> updateDisease (@RequestBody Disease disease){
        Disease dbDisease = diseaseService.updateDisease(disease);
        return new ResponseEntity<>(dbDisease, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteDisease(@PathVariable("id") Long id){
        diseaseService.deleteDisease(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
