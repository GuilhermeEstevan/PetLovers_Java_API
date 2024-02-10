package com.petLovers.services;

import com.petLovers.controller.PetCardController;
import com.petLovers.domain.pet.Pet;
import com.petLovers.domain.pet.petCard.MedicationInfo;
import com.petLovers.domain.pet.petCard.PetCard;
import com.petLovers.domain.pet.petCard.VaccineInfo;
import com.petLovers.dto.petCard.*;
import com.petLovers.repositories.MedicationInfoRepository;
import com.petLovers.repositories.PetCardRepository;
import com.petLovers.repositories.PetRepository;
import com.petLovers.repositories.VaccineInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetCardService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    PetCardRepository petCardRepository;

    @Autowired
    MedicationInfoRepository medicationRepository;
    @Autowired
    VaccineInfoRepository vaccineRepository;

    public PetCardDTO createPetCard(CreatePetCardDTO data, String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isEmpty()) {
            throw new EntityNotFoundException("Pet not found with ID: " + petId);

        }
        Pet pet = optionalPet.get();

        PetCard petCard = new PetCard();
        BeanUtils.copyProperties(data, petCard);
        petCard.setPet(pet);

        PetCard newPetCard = petCardRepository.save(petCard);

        if (data.vaccineInfo() != null) {
            VaccineInfo vaccineInfo = new VaccineInfo();
            BeanUtils.copyProperties(data.vaccineInfo(), vaccineInfo);
            vaccineInfo.setPetCard(newPetCard);
            vaccineInfo = vaccineRepository.save(vaccineInfo);
            newPetCard.setVaccineInfo(vaccineInfo);
        }

        if (data.medicationInfo() != null) {
            MedicationInfo medicationInfo = new MedicationInfo();
            BeanUtils.copyProperties(data.medicationInfo(), medicationInfo);
            medicationInfo.setPetCard(newPetCard);
            medicationInfo = medicationRepository.save(medicationInfo);
            newPetCard.setMedicationInfo(medicationInfo);
        }


        pet.addPetCard(newPetCard);
        petRepository.save(pet);
        newPetCard = petCardRepository.save(newPetCard);

        return new PetCardDTO(newPetCard);
    }

    public PetCardCompleteDTO getPetCardWithVaccineInfo(String petCardId) {
        Optional<PetCard> optionalPetCard = petCardRepository.findById(petCardId);
        if (optionalPetCard.isEmpty()) {
            throw new EntityNotFoundException("PetCard not found with ID: " + petCardId);
        }

        PetCard petCard = optionalPetCard.get();

        return new PetCardCompleteDTO(petCard);
    }
}
