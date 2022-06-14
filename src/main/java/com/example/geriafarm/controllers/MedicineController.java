package com.example.geriafarm.controllers;


import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.services.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/medicine")

public class

MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> medicines = medicineService.findAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Medicine>> getMedicineById(@PathVariable("id") Long id){
        Optional<Medicine> medicine = medicineService.findMedicineById(id);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
    @GetMapping("/asid/{id}")
    public ResponseEntity<List<Medicine>> getMedicinesByAS(@PathVariable("id") Long asId) {
        List<Medicine> medicines = medicineService.findMedicinesContainingAS(asId);
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        Medicine newMedicine = medicineService.createMedicine(medicine);
        return new ResponseEntity<>(newMedicine, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Medicine> updateActiveSubst(@RequestBody Medicine medicine) {
        Medicine dbMedicine = medicineService.updateMedicine(medicine);
        return new ResponseEntity<>(dbMedicine, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{medId}")
    public ResponseEntity<?> deleteMedicine(@PathVariable("medId") Long id) {
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
