package com.doro.accounts.controller;

import com.doro.accounts.dto.ChangePasswordRequest;
import com.doro.accounts.model.User;
import com.doro.accounts.sevice.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
@Data
@AllArgsConstructor
public class AuthController {
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody User user) {
        try {
            User createdUser = userService.signup(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changepass")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        User user = userService.findByUsername(request.getUsername());
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        if (!user.getPassword().equals(request.getOldPassword())) {
            return new ResponseEntity<>("Old password is incorrect", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(request.getNewPassword());
        userService.save(user);
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }

//    @GetMapping("/me")
//    public ResponseEntity<User> getCurrentUser(AuthenticationImpl authentication) {
//        User user = (User) authentication.getPrincipal();
//        return ResponseEntity.ok(user);
//    }
}
