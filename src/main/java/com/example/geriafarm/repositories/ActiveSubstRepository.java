package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.entities.Medicine;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, Long> {

    List<ActiveSubst> findActiveSubstsByNameEqualsOrderByName(String activeSubstName);

    boolean existsActiveSubstsByNameEquals(String activeSubstName);

    List<ActiveSubst> findActiveSubstsByAtcCodeIsStartingWith(String searchAtcCode);

    boolean existsByAtcCode(String atcCode);

}

