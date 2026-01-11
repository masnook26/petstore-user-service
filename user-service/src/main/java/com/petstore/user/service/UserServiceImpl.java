package com.petstore.user.service;

import com.petstore.user.dto.UserRequest;
import com.petstore.user.dto.UserResponse;
import com.petstore.user.exception.UserAlreadyExistsException;
import com.petstore.user.exception.UserNotFoundException;
import com.petstore.user.model.User;
import com.petstore.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public UserResponse findByUsername(String username) {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UserNotFoundException(
        "User not found with username: " + username
      ));

    return mapToResponse(user);
  }

  private UserResponse mapToResponse(User user) {
    return UserResponse.builder()
      .id(user.getId())
      .username(user.getUsername())
      .firstName(user.getFirstName())
      .lastName(user.getLastName())
      .email(user.getEmail())
      .phoneNumber(user.getPhoneNumber())
      .userStatus(user.getUserStatus())
      .build();
  }

  @Override
  @Transactional
  public UserResponse createUser(UserRequest request) {
    validateUniqueFields(request);

    var user = User.builder()
      .username(request.username())
      .firstName(request.firstName())
      .lastName(request.lastName())
      .email(request.email())
      .phoneNumber(request.phoneNumber())
      .userStatus(1) // ATIVO
      .build();

    User savedUser = userRepository.save(user);

    return toResponse(savedUser);
  }

  private void validateUniqueFields(UserRequest request) {
    if (userRepository.existsByUsername(request.username())) {
      throw new UserAlreadyExistsException("Username already exists");
    }

    if (userRepository.existsByEmail(request.email())) {
      throw new UserAlreadyExistsException("Email already exists");
    }
  }

  private UserResponse toResponse(User user) {
    return UserResponse.builder()
      .id(user.getId())
      .username(user.getUsername())
      .firstName(user.getFirstName())
      .lastName(user.getLastName())
      .email(user.getEmail())
      .phoneNumber(user.getPhoneNumber())
      .userStatus(user.getUserStatus())
      .build();
  }

}
