package com.example.geriafarm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveSubst {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    private ATC atc;
//    @ManyToMany
//    @JoinTable (name = "medicines_and_substances")
//    private Set<Medicine> medicines = new HashSet<>();



}
