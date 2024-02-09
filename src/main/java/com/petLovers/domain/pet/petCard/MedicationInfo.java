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
