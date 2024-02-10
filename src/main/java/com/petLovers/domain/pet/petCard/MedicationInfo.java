package com.petLovers.domain.pet.petCard;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medication_info")
public class MedicationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicationType;
    private String frequency;
    private LocalDate nextMedicationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_card_id") // Nome da coluna na tabela medication_info que referencia PetCard
    private PetCard petCard;

    public MedicationInfo() {
    }

    public MedicationInfo(Long id, String medicationType, String frequency, LocalDate nextMedicationDate, PetCard petCard) {
        this.id = id;
        this.medicationType = medicationType;
        this.frequency = frequency;
        this.nextMedicationDate = nextMedicationDate;
        this.petCard = petCard;
    }

    public PetCard getPetCard() {
        return petCard;
    }

    public void setPetCard(PetCard petCard) {
        this.petCard = petCard;
    }

    public String getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(String medicationType) {
        this.medicationType = medicationType;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getNextMedicationDate() {
        return nextMedicationDate;
    }

    public void setNextMedicationDate(LocalDate nextMedicationDate) {
        this.nextMedicationDate = nextMedicationDate;
    }
}
