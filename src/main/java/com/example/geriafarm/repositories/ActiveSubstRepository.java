package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, UUID> {


    List<ActiveSubst> findActiveSubstsByAtcAnatomicalGrEquals(String anatomicalGr);
    List<ActiveSubst> findActiveSubstsByAtc_AnatomicalGrAndAtc_TherapeutSubgr(String anatomicalGr, String therapeutSubgr);
    List<ActiveSubst> findActiveSubstsByAtcPharmacolSubgr(String pharmacologicalSubgr);
    List <ActiveSubst> findActiveSubstsByAtc_AnatomicalGrAndAtc_TherapeutSubgrAndAtc_PharmacolSubgr(String anatomicalGroup, String therapeutSubgr, String PharmacolSubgr);
}
