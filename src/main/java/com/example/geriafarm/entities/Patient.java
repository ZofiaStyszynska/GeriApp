package com.example.geriafarm.entities;

import com.example.geriafarm.enums.Sex;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int age;
    private Sex sex;
    private double weight;
    @ManyToMany
    private Set<Medicine> takenMedicines = new HashSet<>();

}
