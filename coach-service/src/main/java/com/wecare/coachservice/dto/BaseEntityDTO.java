package com.wecare.coachservice.dto;

import com.wecare.coachservice.domain.Gender;
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
