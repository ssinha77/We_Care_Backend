package com.wecare.appointmentservice.service;

import com.wecare.appointmentservice.domain.Appointment;
import com.wecare.appointmentservice.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    Appointment getAppointmentById(String appointmentId);

    List<AppointmentDTO> getAppointmentByUserId(String userId);
}
