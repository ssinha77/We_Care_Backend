package com.wecare.iamservice.dto;

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
