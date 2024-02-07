package com.petLovers.services;

import com.petLovers.domain.user.User;
import com.petLovers.dto.user.LoginDTO;
import com.petLovers.dto.user.RegisterDTO;
import com.petLovers.dto.user.UpdateDTO;
import com.petLovers.dto.user.UserDTO;
import com.petLovers.infra.security.TokenService;
import com.petLovers.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    public UserDTO registerService(RegisterDTO data) {
        User user = new User();
        BeanUtils.copyProperties(data, user);
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        user.setPassword(encryptedPassword);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(UpdateDTO data, String id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        User user = userOptional.get();
        BeanUtils.copyProperties(data, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO findUserById(String id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        return new UserDTO(userOptional.get());
    }

    public String login(LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        System.out.println(usernamePassword);
        var auth = authenticationManager.authenticate(usernamePassword);
        System.out.println(auth);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return token;
    }


}
