package com.example.geriafarm.DTO;

import com.example.geriafarm.entities.Patient;
import com.example.geriafarm.enums.Sex;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class PatientDTO {

    int age;
    Sex sex;
    double weight;
    Set<MedicineDTO> takenMedicines;

    public static PatientDTO fromPatientEnt(Patient patient){
        return new PatientDTO(patient.getAge(),
        patient.getSex(),
        patient.getWeight(),
        patient.getTakenMedicines().stream().map(MedicineDTO::fromMedicineEnt).collect(Collectors.toSet()));
    }
}
