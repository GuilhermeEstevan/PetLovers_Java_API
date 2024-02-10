package com.petLovers.repositories;

import com.petLovers.domain.pet.petCard.PetCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCardRepository extends JpaRepository<PetCard, String> {
}
