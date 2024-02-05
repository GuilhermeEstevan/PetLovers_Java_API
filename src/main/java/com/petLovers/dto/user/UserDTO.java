package com.petLovers.dto.user;

import com.petLovers.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email

) {
    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
