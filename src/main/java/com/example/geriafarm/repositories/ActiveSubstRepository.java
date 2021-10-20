package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "activeSubst", path = "active-substances")
public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, Long> {

public ActiveSubst findActiveSubstsByNameEquals(String activeSubstName);

Page<ActiveSubst> findActiveSubstsByAtcCodeIsStartingWith (@RequestParam("searchCode") String searchCode, Pageable pageable);

}

