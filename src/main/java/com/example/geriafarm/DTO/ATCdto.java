package com.example.geriafarm.DTO;

import com.example.geriafarm.entities.ATC;
import lombok.Value;

@Value
public class ATCdto {

    String atcId;

    public static ATCdto fromATCEntity(ATC atc){
        return new ATCdto(atc.getATCid());
    }
}
