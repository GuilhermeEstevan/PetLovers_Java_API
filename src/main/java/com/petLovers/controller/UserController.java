package com.petLovers.controller;

import com.petLovers.dto.user.*;
import com.petLovers.repositories.UserRepository;
import com.petLovers.services.UserService;
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
    UserService service;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") String id) {
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
                .replacePath("/auth/users/{id}")
                .buildAndExpand(userDto.id()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginDTO data) {
        var token = service.login(data);
        return ResponseEntity.ok().body(new TokenDTO(token));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateUser(
            @RequestBody @Valid UpdateDTO dto,
            @PathVariable(name = "id") String id) {
        var userDto = service.updateUser(dto, id);
        return ResponseEntity.ok().body(userDto);
    }
}
