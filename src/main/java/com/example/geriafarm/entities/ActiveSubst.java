package com.example.geriafarm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
