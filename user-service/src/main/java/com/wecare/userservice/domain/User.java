package com.wecare.userservice.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class User extends BaseEntity{

    @NotNull
    @Size(min = 6,max = 20)
    private String city;

    @NotNull
    @Size(max = 6,min = 6)
    private String pincode;

    @NotNull
    @Size(min = 6,max = 20)
    private String state;

    @NotNull
    @Size(min = 6,max = 20)
    private String country;

}
