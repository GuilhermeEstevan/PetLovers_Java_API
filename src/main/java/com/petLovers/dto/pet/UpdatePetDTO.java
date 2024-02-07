package com.petLovers.dto.pet;

import com.petLovers.domain.pet.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdatePetDTO(
        @NotBlank
        String name,
        @NotBlank
        String species,
        @NotBlank
        String breed,
        @Enumerated(EnumType.STRING)
        Gender gender,
        @NotBlank
        String color,
        @NotNull
        @Past
        LocalDate birthday,
        @NotBlank
        String photo
) {
}
