package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "activeSubst", path = "active-substance")
public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, Long> {

public ActiveSubst findActiveSubstsByNameEquals(String activeSubstName);
//List<ActiveSubst> findActiveSubstsByMedicinesContainingAS(Medicine medicine);
}
