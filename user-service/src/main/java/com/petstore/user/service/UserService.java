package com.petstore.user.service;

import com.petstore.user.dto.UserRequest;
import com.petstore.user.dto.UserResponse;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public interface UserService {

  UserResponse findByUsername(String username);

  UserResponse createUser(UserRequest request);

}
