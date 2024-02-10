package com.petLovers.dto.petCard;

import com.petLovers.domain.pet.petCard.PetCard;

import java.time.LocalDate;

public record PetCardCompleteDTO(
        String serviceType,
        String service,
        String description,
        LocalDate date,
        VaccineInfoDTO vaccineInfoDTO
) {

    public PetCardCompleteDTO(PetCard petCard) {
        this(
                petCard.getServiceType(),
                petCard.getService(),
                petCard.getDescription(),
                petCard.getDate(),
                new VaccineInfoDTO(
                        petCard.getVaccineInfo().getId(),
                        petCard.getVaccineInfo().getVaccineName(),
                        petCard.getVaccineInfo().getDoseNumber(),
                        petCard.getVaccineInfo().getNextDueDate()
                )
        );
    }
}
