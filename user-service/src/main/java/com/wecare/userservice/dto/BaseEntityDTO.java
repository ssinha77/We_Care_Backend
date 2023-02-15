package com.wecare.userservice.dto;

import com.wecare.userservice.domain.Gender;
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
