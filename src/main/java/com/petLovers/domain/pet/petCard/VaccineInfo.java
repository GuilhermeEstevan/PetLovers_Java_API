package com.petLovers.domain.pet.petCard;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vaccine_info")
public class VaccineInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vaccine_name")
    private String vaccineName;
    @Column(name = "dose_number")
    private String doseNumber;
    private LocalDate nextDueDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_card_id") // Nome da coluna na tabela vaccine_info que referencia PetCard
    private PetCard petCard;

    public VaccineInfo() {
    }

    public VaccineInfo(Long id, String vaccineName, String doseNumber, LocalDate nextDueDate, PetCard petCard) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.doseNumber = doseNumber;
        this.nextDueDate = nextDueDate;
        this.petCard = petCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public PetCard getPetCard() {
        return petCard;
    }

    public void setPetCard(PetCard petCard) {
        this.petCard = petCard;
    }


    @Override
    public String toString() {
        return "VaccineInfo{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", doseNumber='" + doseNumber + '\'' +
                ", nextDueDate=" + nextDueDate +
                ", petCard=" + petCard +
                '}';
    }
}
