package com.example.geriafarm.DTO;

import com.example.geriafarm.entities.ActiveSubst;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class ActiveSubstDTO {


    String name;
    String atcCode;


    public static ActiveSubstDTO fromActiveSubstEnt(ActiveSubst activeSubst) {
        return new ActiveSubstDTO(
                activeSubst.getName(),
                activeSubst.getAtcCode()

        );

    }
}
