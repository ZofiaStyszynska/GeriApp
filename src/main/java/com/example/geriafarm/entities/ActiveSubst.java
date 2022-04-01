package com.example.geriafarm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveSubst {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String group;
    @Column(unique=true)
    @NonNull
    private String atcCode;
    @ManyToMany(mappedBy = "activeSubsts")
    @JsonManagedReference(value = "medicine-activeSubst")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Medicine> medicines = new HashSet<>();





}
