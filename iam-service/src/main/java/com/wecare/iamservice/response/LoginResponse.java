package com.wecare.iamservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private Boolean isAuthenticated;
    private String accessToken;
}
