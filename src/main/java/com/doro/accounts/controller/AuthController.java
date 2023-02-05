package com.doro.accounts.controller;

import com.doro.accounts.exception.AppException;
import com.doro.accounts.model.Role;
import com.doro.accounts.model.User;
import com.doro.accounts.repository.RoleName;
import com.doro.accounts.repository.RoleRepository;
import com.doro.accounts.repository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@Data
public class AuthController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Check if the user already exists
        User existingUser = userRepository.findByUsername(user.getName());
        if (existingUser != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        // Set default role for new user
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new AppException("User Role not set."));
        user.setRoles(Collections.singleton(userRole));

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        User result = userRepository.save(user);

        return new ResponseEntity<>("Successful signup", HttpStatus.OK);
    }


//    @PostMapping("/changepass")
//    public ResponseEntity<String> changePassword(@RequestBody User user) {
//        // Implementation to handle password change
//        return new ResponseEntity<>("Successful password change", HttpStatus.OK);
//    }

}
