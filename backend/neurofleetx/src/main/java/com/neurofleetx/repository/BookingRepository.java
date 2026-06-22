package com.neurofleetx.repository;

import com.neurofleetx.entity.Booking;
import com.neurofleetx.entity.User;
import com.neurofleetx.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDriver(User driver);

    List<Booking> findByVehicle(Vehicle vehicle);
}
