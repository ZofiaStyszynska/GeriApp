package com.example.geriafarm.DTO;

import com.example.geriafarm.entities.ATC;
import lombok.*;
import org.springframework.lang.Nullable;

@Value
@Builder(access = AccessLevel.PUBLIC)
public class ATCdto {

    String atcDto;

    public static ATCdto fromATCEntity(ATC atc) {
        StringBuilder sb = new StringBuilder();
        sb.append(atc.getAnatomicalGr());
        sb.append(atc.getTherapeutSubgr());
        sb.append(atc.getPharmacolSubgr());
        sb.append(atc.getChemicalSubgr());
        sb.append(atc.getChemicalSubst());

        return new ATCdto(
                sb.toString()
        );

    }
}
