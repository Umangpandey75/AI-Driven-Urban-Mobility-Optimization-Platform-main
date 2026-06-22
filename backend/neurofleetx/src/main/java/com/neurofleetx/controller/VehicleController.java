package com.neurofleetx.controller;

import com.neurofleetx.dto.VehicleRequest;
import com.neurofleetx.entity.Vehicle;
import com.neurofleetx.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/vehicles")
@CrossOrigin("*")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequest req) {
        return ResponseEntity.ok(vehicleService.addVehicle(req));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
}
