package com.example.geriafarm.repositories;

import com.example.geriafarm.entities.ATC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ATCRepository extends JpaRepository<ATC, UUID>{


}
