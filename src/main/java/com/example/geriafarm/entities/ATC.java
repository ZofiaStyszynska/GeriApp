package com.example.geriafarm.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Embeddable
public class ATC {

    @Id
    private UUID id;
    private String ATCid;

    public String getAnatomicalGroup(ATC atc) {
        return atc.getATCid().substring(0, 1);
    }

    public String getTherapeuticSubgroup(ATC atc) {
        return atc.getATCid().substring(1, 3);
    }

    public String getPharmacologicalSubgroup(ATC atc) {
        if (atc.getATCid().length() > 3) {
            return atc.getATCid().substring(3, 4);
        }
        return "Pharmacological group not given";
    }

    String getChemicalSubgroup(ATC atc) {
        if (atc.getATCid().length() > 4) {
            return atc.getATCid().substring(4, 5);
        }
        return "Chemical group not given";
    }

    String getChemicalSubstance(ATC atc) {
        if (atc.getATCid().length() > 5) {
            return atc.getATCid().substring(5);
        }
        return "Chemical substance not known";
    }
}
