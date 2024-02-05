package com.petLovers.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @Size(min = 6, max = 20)
        String password
) {
}
