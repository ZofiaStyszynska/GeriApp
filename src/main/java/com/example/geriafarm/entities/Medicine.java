package com.example.geriafarm.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medId;
    private String tradeName;
    private String dosage;
    private String formulation; //TODO zamienić na drogę podania
    @ManyToMany
    private Set<ActiveSubst> activeSubsts = new HashSet<>();
    private boolean foodInteraction; //TODO sprawdzić wyszukiwarkę i jak ją podłączyć - "Kto ma lek"


}
