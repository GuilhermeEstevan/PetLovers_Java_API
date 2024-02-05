package com.petLovers.services;

import com.petLovers.domain.user.User;
import com.petLovers.dto.user.RegisterDTO;
import com.petLovers.dto.user.UpdateDTO;
import com.petLovers.dto.user.UserDTO;
import com.petLovers.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository repository;

    public UserDTO registerService(RegisterDTO data) {
        User user = new User();
        BeanUtils.copyProperties(data, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(UpdateDTO data, Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        User user = userOptional.get();
        BeanUtils.copyProperties(data, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO findUserById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("Id " + id + " não encontrado!");
        }
        return new UserDTO(userOptional.get());
    }
}
