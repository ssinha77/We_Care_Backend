package com.wecare.iamservice.controller;

import com.wecare.iamservice.Authorised;
import com.wecare.iamservice.response.LoginRequest;
import com.wecare.iamservice.response.LoginResponse;
import com.wecare.iamservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:3000"},methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authenticationService.authenticate(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
    }

    @Authorised(roles = "COACH")
    @GetMapping("/test")
    public String check(@RequestHeader(value = "Authorization") String authorization){
        return "success";
    }
}
