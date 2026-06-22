package com.neurofleetx.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.neurofleetx.repository.UserRepository;
import com.neurofleetx.dto.RegisterRequest;
import com.neurofleetx.dto.LoginRequest;
import com.neurofleetx.dto.LoginResponse;
import com.neurofleetx.entity.User;
import com.neurofleetx.entity.Role;
import com.neurofleetx.entity.Vehicle;
import com.neurofleetx.dto.RouteRequest;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User register(RegisterRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword()) // No security as required
                .role(Role.valueOf(req.getRole()))
                .build();
        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user == null || !user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name());
    }
}
