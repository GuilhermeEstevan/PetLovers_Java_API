package com.petLovers.domain.pet.petCard;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pet_cards")
public class PetCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String serviceType;
    private String service;
    private String description;
    private LocalDate date;


//    @OneToOne(mappedBy = "petCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private VaccineInfo vaccineInfo;
//
//    @OneToOne(mappedBy = "petCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private MedicationInfo medicationInfo;


}
