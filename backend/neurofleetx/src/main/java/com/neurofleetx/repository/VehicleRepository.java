package com.neurofleetx.repository;

import com.neurofleetx.entity.Vehicle;
import com.neurofleetx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByDriver(User driver);
}
