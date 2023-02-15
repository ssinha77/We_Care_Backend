package com.wecare.iamservice.service;

import com.wecare.iamservice.response.LoginRequest;
import com.wecare.iamservice.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse authenticate(LoginRequest loginRequest);
}
