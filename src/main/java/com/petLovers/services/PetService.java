package com.petLovers.services;

import com.petLovers.domain.pet.Pet;
import com.petLovers.dto.pet.CreatePetDTO;
import com.petLovers.dto.pet.PetDTO;
import com.petLovers.dto.pet.UpdatePetDTO;
import com.petLovers.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;


    public PetDTO createPetService(CreatePetDTO data) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(data, pet);
        pet = repository.save(pet);
        return new PetDTO(pet);
    }

    public PetDTO updatePet(UpdatePetDTO data, String id) {
        Optional<Pet> optionalPet = repository.findById(id);
        if (optionalPet.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        Pet pet = optionalPet.get();
        BeanUtils.copyProperties(data, pet);
//        if (data.gender() != null) {
//            pet.setGender(data.gender());
//        }
        Pet updatedPet = repository.save(pet);
        return new PetDTO(updatedPet);
    }

    public List<PetDTO> getAll() {
        List<Pet> petList = repository.findAll();
        return petList.stream().map(PetDTO::new).toList();
    }

    public PetDTO getSinglePetById(String id) {
        Optional<Pet> optionalPet = repository.findById(id);
        if (optionalPet.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        Pet pet = optionalPet.get();
        return new PetDTO(pet);
    }
}
