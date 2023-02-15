package com.wecare.appointmentservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "appointment")
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    private String id;
    private String userId;
    private String coachId;
    private String date;
    private String slot;
}
