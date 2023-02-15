package com.wecare.userservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends BaseEntityDTO {
    private String city;
    private String pincode;
    private String state;
    private String country;
}
