package com.example.geriafarm.entities;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medId;
    private String tradeName;
    @Column(columnDefinition = "varchar(255) default null")
    private String dosage;
    @Column(columnDefinition = "varchar(255) default null")
    private String routeOfAdministration;
    @ManyToMany
    private Set<ActiveSubst> activeSubsts = new HashSet<>();
    @Column(nullable = true)
    private boolean foodInteraction; //TODO sprawdzić wyszukiwarkę i jak ją podłączyć - "Kto ma lek"


}
