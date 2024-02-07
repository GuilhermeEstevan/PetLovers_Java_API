package com.petLovers.dto.user;

import com.petLovers.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record UserDTO(
        @NotBlank
        String id,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String lastName,
        @NotBlank
        String phone

) {
    public UserDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getLastName(),
                user.getPhone());
    }
}
