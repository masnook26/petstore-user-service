package com.petstore.user.controller;

import com.petstore.user.dto.UserRequest;
import com.petstore.user.dto.UserResponse;
import com.petstore.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/{username}")
  public ResponseEntity<@NonNull UserResponse> getUserByName(@PathVariable String username) {
    UserResponse response = userService.findByUsername(username);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping
  public ResponseEntity<@NonNull UserResponse> createUser(@RequestBody @Valid UserRequest request) {
    UserResponse response = userService.createUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}
