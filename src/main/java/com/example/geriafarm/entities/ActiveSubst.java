package com.example.geriafarm.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ActiveSubst {


    @Id
    private String id;
    private String name;
    private String ATC;
//    @ManyToMany
//    @JoinTable (name = "medicines_and_substances")
//    private Set<Medicine> medicines = new HashSet<>();



}
