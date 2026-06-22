package com.neurofleetx.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;

import com.neurofleetx.service.AuthService;
import com.neurofleetx.dto.RegisterRequest;
import com.neurofleetx.dto.LoginRequest;
import com.neurofleetx.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        LoginResponse response = authService.login(req);

        if (response == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(response);
    }
}
