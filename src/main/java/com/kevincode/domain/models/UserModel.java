package com.kevincode.domain.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String email;
    private String username;
    private String password;
    private Set<String> roles;
}
