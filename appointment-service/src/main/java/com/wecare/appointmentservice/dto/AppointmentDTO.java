package com.wecare.appointmentservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wecare.appointmentservice.domain.Coach;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDTO {
    private String userId;
//    @JsonIgnore
    private String coachId;
    private CoachDTO coach;
    private String date;
    private String slot;

}
