package com.petLovers.dto.petCard;

import java.time.LocalDate;

public record MedicationInfoDTO(
        String medicationType,
        String frequency,
        LocalDate nextMedicationDate
) {
}