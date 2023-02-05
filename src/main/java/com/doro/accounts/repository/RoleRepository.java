package com.doro.accounts.repository;

import com.doro.accounts.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName role) throws Exception;
}
