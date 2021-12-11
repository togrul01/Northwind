package com.core.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;

    @Column(name="email",nullable = false)
    @Email
    @NotBlank // " tell
    @NotNull
    private String email;

    @Column(name ="password",nullable = false)
    @NotBlank
    @NotNull
    private String password;
}
