// src/main/java/com/example/projeto/repository/UserRepository.java
package com.example.projeto04.repository;

import com.example.projeto04.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
