package com.neurofleetx.service;

import com.neurofleetx.entity.Role;
import com.neurofleetx.entity.User;
import com.neurofleetx.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.neurofleetx.entity.Vehicle;
import com.neurofleetx.dto.RouteRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final UserRepository userRepository;

    public List<User> getAllDrivers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.DRIVER)
                .toList();
    }

    public User getDriverById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
