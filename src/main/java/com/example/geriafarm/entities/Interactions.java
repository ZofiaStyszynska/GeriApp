package com.example.geriafarm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany
    @JoinColumn
    private Set<ActiveSubst> atcCodes = new HashSet<>();
    @OneToMany
    @JoinColumn
    private Set<ICD10> ICD10Codes = new HashSet<>();
}
