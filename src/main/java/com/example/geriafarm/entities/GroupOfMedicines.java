package com.example.geriafarm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class GroupOfMedicines {

    @Id
    private String id;
    private String name;
    @OneToMany
    private Set<ActiveSubst> activeSubsts;
}
