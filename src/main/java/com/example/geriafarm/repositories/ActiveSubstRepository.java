package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ActiveSubst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActiveSubstRepository extends JpaRepository<ActiveSubst, UUID> {
}