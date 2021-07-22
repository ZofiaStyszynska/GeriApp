package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

List<Medicine> findMedicinesByActiveSubsts(String activeSubst);
}
