package com.example.geriafarm.DTO;


import com.example.geriafarm.entities.Medicine;
import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
@Builder
public class MedicineDTO {

    String tradeName;
    String dosage;
    String formulation;
    Set<ActiveSubstDTO> activeSubsts;
    boolean foodInteraction;

    public static MedicineDTO fromMedicineEnt(Medicine medicine){
       return new MedicineDTO(
               medicine.getTradeName(),
               medicine.getDosage(),
               medicine.getFormulation(),
               medicine.getActiveSubsts().stream().map(ActiveSubstDTO::fromActiveSubstEnt).collect(Collectors.toSet()),
               medicine.isFoodInteraction());
    }


}
