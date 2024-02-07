package com.petLovers.repositories;

import com.petLovers.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findById(String id);

    UserDetails findByName(String username);

    UserDetails findByEmail(String email);
}
