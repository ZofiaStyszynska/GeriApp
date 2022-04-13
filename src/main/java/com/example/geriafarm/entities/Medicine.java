package com.example.geriafarm.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "medId")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medId;
    private String tradeName;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "medicine_dosages", joinColumns = @JoinColumn(name = "medicine_id"))
    @Column(name = "dosages")
    private Set<String> dosages = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "medicine_active_substs",
            joinColumns = @JoinColumn(name = "medicine_med_id"),
            inverseJoinColumns = @JoinColumn(name = "active_substs_id"))
        @OrderBy

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ActiveSubst> activeSubsts = new HashSet<>();


}
