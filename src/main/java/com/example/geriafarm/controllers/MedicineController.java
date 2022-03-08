package com.example.geriafarm.controllers;


import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import com.example.geriafarm.services.implementations.MedicineServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/medicine")

public class MedicineController {

    private final MedicineServiceImpl medicineService;

    public MedicineController(MedicineServiceImpl medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> medicines = medicineService.findAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Medicine> addActiveSubst(@RequestBody Medicine medicine) {
        Medicine newMedicine = medicineService.createMedicine(medicine);
        return new ResponseEntity<>(medicine, HttpStatus.CREATED);
    }

}