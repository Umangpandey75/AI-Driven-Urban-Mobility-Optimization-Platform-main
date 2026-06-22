package com.neurofleetx.repository;

import com.neurofleetx.entity.MaintenanceLog;
import com.neurofleetx.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceLogRepository extends JpaRepository<MaintenanceLog, Long> {

    List<MaintenanceLog> findByVehicle(Vehicle vehicle);
}
