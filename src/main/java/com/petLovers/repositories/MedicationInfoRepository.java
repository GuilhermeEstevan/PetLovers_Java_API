package com.petLovers.repositories;

import com.petLovers.domain.pet.petCard.MedicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationInfoRepository extends JpaRepository<MedicationInfo, Long> {
}
