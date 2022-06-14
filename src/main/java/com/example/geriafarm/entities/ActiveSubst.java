package com.example.geriafarm.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ActiveSubst {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String group;
    @Column
    @NonNull
    private String atcCode;
    @ManyToMany(mappedBy = "activeSubsts", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Medicine> medicines = new HashSet<>();





}
