package com.example.geriafarm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ICD10 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nullable
    private String nameOfDisease;
    private String ICD10;

}
