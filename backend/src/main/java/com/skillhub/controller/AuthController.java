package com.skillhub.controller;

import com.skillhub.dto.RegisterRequest;
import com.skillhub.service.KeycloakService;
import com.skillhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final KeycloakService keycloakService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        keycloakService.createUser(request.getUsername(), request.getEmail(), request.getPassword());
        userService.saveUserInDatabase(request);
        return ResponseEntity.ok("User registered successfully");
    }
}

