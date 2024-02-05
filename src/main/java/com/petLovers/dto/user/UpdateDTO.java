package com.petLovers.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email) {
}
