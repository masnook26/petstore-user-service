package com.petstore.user.service;

import com.petstore.user.dto.UserResponse;
import com.petstore.user.exception.UserNotFoundException;
import com.petstore.user.model.User;
import com.petstore.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
