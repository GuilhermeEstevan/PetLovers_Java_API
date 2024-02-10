package com.petLovers.domain.pet.petCard;

import com.petLovers.domain.pet.Pet;
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
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne(mappedBy = "petCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VaccineInfo vaccineInfo;

    @OneToOne(mappedBy = "petCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicationInfo medicationInfo;

    public PetCard() {
    }

    public PetCard(String id, String serviceType, String service, String description, LocalDate date, VaccineInfo vaccineInfo, MedicationInfo medicationInfo) {
        this.id = id;
        this.serviceType = serviceType;
        this.service = service;
        this.description = description;
        this.date = date;
        this.vaccineInfo = vaccineInfo;
        this.medicationInfo = medicationInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public VaccineInfo getVaccineInfo() {
        return vaccineInfo;
    }

    public void setVaccineInfo(VaccineInfo vaccineInfo) {
        this.vaccineInfo = vaccineInfo;
    }

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(MedicationInfo medicationInfo) {
        this.medicationInfo = medicationInfo;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "PetCard{" +
                "id='" + id + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", service='" + service + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", pet=" + pet +
                ", vaccineInfo=" + vaccineInfo +
                ", medicationInfo=" + medicationInfo +
                '}';
    }
}
