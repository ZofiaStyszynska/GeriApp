package com.example.geriafarm.entities;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID medId;
    private String tradeName;
    private String dosage;
    private String formulation;
    @ManyToMany
    private Set<ActiveSubst> activeSubsts = new HashSet<>();
    private boolean foodInteraction;


}
