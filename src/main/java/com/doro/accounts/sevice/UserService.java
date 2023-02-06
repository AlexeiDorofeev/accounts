package com.doro.accounts.sevice;

import com.doro.accounts.model.Role;
import com.doro.accounts.model.User;
import com.doro.accounts.repository.RoleRepository;
import com.doro.accounts.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public User signup(User user) {
        if (user.getRole() == null) {
            user.setRole(new Role(2L, "DEFAULT"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
