package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, Long> {


    List<ActiveSubst> findActiveSubstsByNameStartingWithOrderByName(String activeSubstName);

    boolean existsActiveSubstsByNameEquals(String activeSubstName);
    boolean existsActiveSubstsByAtcCodeEquals (String atcCode);

    List<ActiveSubst> findActiveSubstsByAtcCodeIsStartingWith(String searchAtcCode);

    boolean existsByAtcCode(String atcCode);
    ActiveSubst findActiveSubstsByAtcCodeEquals(String atcCode);

   // @Query("select a from ActiveSubst a join a.medicines m where m.medId = :id")
    @Query("select a from ActiveSubst a join fetch a.medicines m where m.medId = ?1")
    List<ActiveSubst> findActiveSubstsByMedicineId(Long medId);


}


