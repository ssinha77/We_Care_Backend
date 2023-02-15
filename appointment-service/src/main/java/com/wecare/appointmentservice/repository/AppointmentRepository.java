package com.wecare.appointmentservice.repository;

import com.wecare.appointmentservice.domain.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {
    List<Appointment> findAllByUserId(String userId);
}
