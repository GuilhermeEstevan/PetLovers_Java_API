package com.petLovers.dto.pet;

import com.petLovers.domain.pet.Pet;
import com.petLovers.domain.pet.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record PetDTO(
        @NotNull
        String id,
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
        @Past
        @NotNull
        LocalDate birthday,
        @NotBlank
        String photo

) {
    public PetDTO(Pet pet) {
        this(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getGender(),
                pet.getColor(),
                pet.getBirthday(),
                pet.getPhoto()
        );
    }
}
