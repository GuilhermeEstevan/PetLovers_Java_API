package com.petLovers.dto.petCard;

import java.time.LocalDate;

public record VaccineInfoDTO(
        Long id,
        String vaccineName,
        String doseNumber,
        LocalDate nextDueDate) {

}
