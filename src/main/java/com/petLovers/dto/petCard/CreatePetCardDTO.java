package com.petLovers.dto.petCard;

import jakarta.validation.constraints.Past;

import java.time.LocalDate;


public record CreatePetCardDTO(
        String serviceType,
        String service,
        String description,
        @Past
        LocalDate date,
        VaccineInfoDTO vaccineInfo,
        MedicationInfoDTO medicationInfo
) {
}
