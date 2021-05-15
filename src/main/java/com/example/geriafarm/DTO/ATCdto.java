package com.example.geriafarm.DTO;

import com.example.geriafarm.entities.ATC;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
@Builder
public class ATCdto {

    String anatomicalGr;
    String therapeutSubgr;
    String pharmacolSubgr;
    String chemicalSubgr;
    String chemicalSubst;

    public static ATCdto fromATCEntity(ATC atc){
        return new ATCdto(
                atc.getAnatomicalGr(),
                atc.getTherapeutSubgr(),
                atc.getPharmacolSubgr(),
                atc.getChemicalSubgr(),
                atc.getChemicalSubst()
        );

    }
}
