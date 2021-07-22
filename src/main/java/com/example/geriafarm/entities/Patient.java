package com.example.geriafarm.entities;

import com.example.geriafarm.enums.Sex;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int age;
    private Sex sex;
    private double weight;
    @ManyToMany
    private Set<Medicine> takenMedicines = new HashSet<>();
    @ManyToMany
    private Set<ICD10> diseases = new HashSet<>();
    //TODO choroby wg klas. ICD10
    //TODO poziom kreatyniny

}
