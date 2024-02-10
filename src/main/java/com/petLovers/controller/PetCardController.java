package com.petLovers.controller;

import com.petLovers.domain.pet.petCard.PetCard;
import com.petLovers.dto.petCard.CreatePetCardDTO;
import com.petLovers.dto.petCard.PetCardCompleteDTO;
import com.petLovers.dto.petCard.PetCardDTO;
import com.petLovers.repositories.PetCardRepository;
import com.petLovers.services.PetCardService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets/petCard")
public class PetCardController {

    @Autowired
    PetCardService service;

    @PostMapping("/{id}")
    public ResponseEntity createPetCard(@PathVariable("id") String id, @RequestBody CreatePetCardDTO data) {

        PetCardDTO petCardDTO = service.createPetCard(data, id);
        return ResponseEntity.ok().body(petCardDTO);
    }

    @GetMapping("/{petCardId}")
    public ResponseEntity<PetCardCompleteDTO> getPetCardWithVaccineInfo(@PathVariable String petCardId) {
        PetCardCompleteDTO cardCompleteDTO = service.getPetCardWithVaccineInfo(petCardId);
        return ResponseEntity.ok().body(cardCompleteDTO);
    }

}
