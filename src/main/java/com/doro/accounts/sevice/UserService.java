package com.doro.accounts.sevice;

import com.doro.accounts.exception.RoleNotFoundException;
import com.doro.accounts.model.Role;
import com.doro.accounts.model.User;
import com.doro.accounts.repository.RoleRepository;
import com.doro.accounts.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Value("${app.defaultRoleId}")
    private Long defaultRoleId;

    public User signup(User user) {
        if (user.getRole() == null) {
            Role defaultRole = roleRepository.findById(defaultRoleId)
                .orElseThrow(() -> new RoleNotFoundException("Default role not found"));
            user.setRole(defaultRole);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByName(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
