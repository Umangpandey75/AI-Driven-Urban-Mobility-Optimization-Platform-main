package com.neurofleetx.controller;

import com.neurofleetx.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriver(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }
}
