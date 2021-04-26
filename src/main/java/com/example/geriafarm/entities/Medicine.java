package com.example.geriafarm.entities;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String medId;
    private String tradeName;
    private String dosage;
    private String formulation;
    @ManyToMany
    private Set<ActiveSubst> activeSubsts = new HashSet<>();
    private boolean foodInteraction;


}
