package com.wecare.iamservice.response;

import com.wecare.iamservice.domain.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;
    private UserType loginAs;
}
