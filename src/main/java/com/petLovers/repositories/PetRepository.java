package com.petLovers.repositories;

import com.petLovers.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {

    List<Pet> findAllByCreatedBy(String userId);

}
