package com.doro.accounts.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
