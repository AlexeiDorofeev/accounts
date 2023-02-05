package com.doro.accounts.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Role {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
