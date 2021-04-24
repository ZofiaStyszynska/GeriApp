package com.example.geriafarm.entities;

import com.example.geriafarm.enums.Sex;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Patient {

    @Id
    private String id;
    private int age;
    private Sex sex;
    private double weight;
    @ManyToMany
    private Set<Medicine> takenMedicines = new HashSet<>();

}
