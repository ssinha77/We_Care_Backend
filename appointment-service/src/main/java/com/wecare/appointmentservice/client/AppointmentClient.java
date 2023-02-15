package com.wecare.appointmentservice.client;

import com.wecare.appointmentservice.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "appointment-service")
public interface AppointmentClient {

    @PostMapping("/api/appointments")
    ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointment);

    @GetMapping("/api/appointments/{userId}")
    ResponseEntity<List<AppointmentDTO>> getAppointments(@PathVariable String userId);
}
