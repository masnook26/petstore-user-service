package com.petstore.user.repository;

import com.petstore.user.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public interface UserRepository extends JpaRepository<@NonNull User, @NonNull Long> {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

}
