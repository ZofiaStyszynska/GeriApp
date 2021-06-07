package com.example.geriafarm.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
//@Embeddable
public class ATC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String anatomicalGr;
    private String therapeutSubgr;
    private String pharmacolSubgr;
    @Nullable
    private String chemicalSubgr;
    @Nullable
    private String chemicalSubst;


}
