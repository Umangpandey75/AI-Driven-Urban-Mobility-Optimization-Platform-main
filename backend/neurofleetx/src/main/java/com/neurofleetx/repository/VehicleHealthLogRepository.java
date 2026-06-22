package com.neurofleetx.repository;

import com.neurofleetx.entity.VehicleHealthLog;
import com.neurofleetx.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleHealthLogRepository extends JpaRepository<VehicleHealthLog, Long> {

    List<VehicleHealthLog> findByVehicle(Vehicle vehicle);
}
