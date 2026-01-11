package com.petstore.user.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 50)
  private String username;

  @Column(length = 100)
  private String firstName;

  @Column(length = 100)
  private String lastName;

  @Column(nullable = false, unique = true, length = 150)
  private String email;

  @Column(length = 15)
  private String phoneNumber;

  private Integer userStatus;

}
