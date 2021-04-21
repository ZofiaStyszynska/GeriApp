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
    @ManyToMany
    @JoinTable (name = "medicines_and_substances")
    private Set<Medicine> medicines = new HashSet<>();
    @ManyToOne
    private GroupOfMedicines group;


}
