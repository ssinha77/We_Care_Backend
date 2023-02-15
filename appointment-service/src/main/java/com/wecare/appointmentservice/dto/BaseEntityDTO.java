package com.wecare.appointmentservice.dto;

import com.wecare.appointmentservice.domain.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseEntityDTO {

    String id;
    String name;
    String password;
    String mobile;
    Gender gender;
    String dateOfBirth;
}
