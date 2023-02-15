package com.wecare.appointmentservice.service;

import com.wecare.appointmentservice.client.CoachClient;
import com.wecare.appointmentservice.domain.Appointment;
import com.wecare.appointmentservice.dto.AppointmentDTO;
import com.wecare.appointmentservice.dto.CoachDTO;
import com.wecare.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private CoachClient coachClient;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO,appointment);

        appointment = appointmentRepository.save(appointment);
        BeanUtils.copyProperties(appointment,appointmentDTO);
        return appointmentDTO;
    }

    @Override
    public Appointment getAppointmentById(String appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(new Appointment());
    }

    @Override
    public List<AppointmentDTO> getAppointmentByUserId(String userId) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        List<Appointment> appointments = appointmentRepository.findAllByUserId(userId);


        var list =  appointments.stream().map(appointment -> {
            CoachDTO coachDTO = coachClient.getCoach(appointment.getCoachId());
            BeanUtils.copyProperties(appointment, appointmentDTO);
            appointmentDTO.setCoach(coachDTO);
            return appointmentDTO;
        }).toList();

        return list;


    }
}
