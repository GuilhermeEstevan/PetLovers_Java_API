package com.petLovers.repositories;

import com.petLovers.domain.pet.petCard.VaccineInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineInfoRepository extends JpaRepository<VaccineInfo, Long> {
}
