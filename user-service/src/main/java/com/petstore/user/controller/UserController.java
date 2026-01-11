package com.petstore.user.controller;

import com.petstore.user.model.User;
import com.petstore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<@NonNull User> getUserByName(@PathVariable String username) {
    User user = userService.getUserByName(username);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

}
