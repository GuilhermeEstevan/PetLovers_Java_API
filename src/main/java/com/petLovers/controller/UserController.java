package com.petLovers.controller;

import com.petLovers.dto.user.RegisterDTO;
import com.petLovers.dto.user.UpdateDTO;
import com.petLovers.dto.user.UserDTO;
import com.petLovers.repositories.UserRepository;
import com.petLovers.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserRepository repository;
    @Autowired
    AuthService service;

    //
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") Long id) {
        UserDTO userDTO = service.findUserById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (repository.existsByEmail(data.email())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
        var userDto = service.registerService(data);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath("/users/{id}")
                .buildAndExpand(userDto.id()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateUser(
            @RequestBody @Valid UpdateDTO dto,
            @PathVariable(name = "id") Long id) {
        var userDto = service.updateUser(dto, id);
        return ResponseEntity.ok().body(userDto);
    }
}
