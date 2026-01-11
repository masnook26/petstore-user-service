package com.petstore.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 10/01/2026
 */
@Builder
public record UserRequest(

  @NotBlank(message = "")
  @Size(max = 50, message = "")
  String username,

  @Size(max = 100, message = "")
  String firstName,

  @Size(max = 100, message = "")
  String lastName,

  @NotBlank(message = "")
  @Email(message = "")
  @Size(max = 150, message = "")
  String email,

  @Size(max = 15, message = "")
  String phoneNumber
) {
}
