package com.petstore.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 10/01/2026
 */
@Builder
public record UserRequest(
  @NotNull
  String username,

  String firstName,

  String lastName,

  @Email
  @NotNull
  String email,

  String phoneNumber,

  Integer userStatus
) {
}
