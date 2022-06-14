package com.example.geriafarm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "interactions_atc_codes", joinColumns = @JoinColumn(name = "interactions_id"))
    @Column(name = "atcCodes")
    private Set<String> atcCodes = new HashSet<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "interactions_icd10_codes", joinColumns = @JoinColumn(name = "interactions_id"))
    @Column(name = "icd10codes")
    private Set<String> ICD10Codes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interactions that = (Interactions) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(atcCodes, that.atcCodes) && Objects.equals(ICD10Codes, that.ICD10Codes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, atcCodes, ICD10Codes);
    }
}
