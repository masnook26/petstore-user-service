package com.petstore.user.service;

import com.petstore.user.model.User;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public interface UserService {

  User getUserByName(String username);

}
