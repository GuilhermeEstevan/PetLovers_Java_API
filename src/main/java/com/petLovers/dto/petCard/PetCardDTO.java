package com.petLovers.dto.petCard;

import com.petLovers.domain.pet.petCard.PetCard;

import java.time.LocalDate;

public record PetCardDTO(

        String serviceType,
        String service,
        String description,
        LocalDate date

) {

    public PetCardDTO(PetCard petCard) {
        this(
                petCard.getServiceType(),
                petCard.getService(),
                petCard.getDescription(),
                petCard.getDate());
    }
}
