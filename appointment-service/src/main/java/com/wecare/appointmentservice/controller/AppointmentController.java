package com.wecare.appointmentservice.controller;

import com.wecare.appointmentservice.dto.AppointmentDTO;
import com.wecare.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointment) {
        AppointmentDTO response = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointments(@PathVariable String userId) {
        List<AppointmentDTO> response = appointmentService.getAppointmentByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
