package com.petLovers.controller;

import com.petLovers.domain.pet.Pet;
import com.petLovers.dto.pet.CreatePetDTO;
import com.petLovers.dto.pet.PetDTO;
import com.petLovers.dto.pet.UpdatePetDTO;
import com.petLovers.repositories.PetRepository;
import com.petLovers.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetRepository repository;

    @Autowired
    PetService service;

    @PostMapping
    public ResponseEntity createPet(@RequestBody @Valid CreatePetDTO data) {
        var petDTO = service.createPetService(data);
        return ResponseEntity.ok().body(petDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatedPet(@PathVariable(value = "id") String id, @RequestBody @Valid UpdatePetDTO data) {
        var petDTO = service.updatePet(data, id);
        return ResponseEntity.ok().body(petDTO);
    }

    @GetMapping()
    public ResponseEntity<List<PetDTO>> getAll() {
        List<PetDTO> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getSinglePetById(@PathVariable(value = "id") String id) {
        PetDTO petDTO = service.getSinglePetById(id);
        return ResponseEntity.ok().body(petDTO);
    }
}
