package com.example.geriafarm.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class ActiveSubst {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @OneToOne
    private ATC atc;
//    @ManyToMany
//    @JoinTable (name = "medicines_and_substances")
//    private Set<Medicine> medicines = new HashSet<>();



}
