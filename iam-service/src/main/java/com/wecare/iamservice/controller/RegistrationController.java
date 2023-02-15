package com.wecare.iamservice.controller;

import com.wecare.iamservice.Authorised;
import com.wecare.iamservice.client.CoachClient;
import com.wecare.iamservice.client.UserClient;
import com.wecare.iamservice.dto.CoachDTO;
import com.wecare.iamservice.dto.UserDTO;
import com.wecare.iamservice.response.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/registration")
@CrossOrigin("http://localhost:3000")
public class RegistrationController implements UserClient,CoachClient{


    @Autowired
    private CoachClient coachClient;

    @Autowired
    private UserClient userClient;

    @Override
    @PostMapping("/coaches")
    public CoachDTO create(CoachDTO coach) {
        return coachClient.create(coach);
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public Optional<CoachDTO> validateCoach(LoginRequest loginRequest) {
        return Optional.empty();
    }

    @Override
    @PostMapping("/users")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userClient.create(userDTO);
    }

    @Override
    @GetMapping("/{userId}")
    @Authorised(roles = "user",selfCheck = true)
    public ResponseEntity<UserDTO> getUser(@RequestHeader(value = "Authorization") String authorization, String userId) {
        return userClient.getUser(authorization,userId);
    }

    @Override
    public ResponseEntity<Optional<UserDTO>> validateCredentials(LoginRequest loginRequest) {
        return null;
    }
}
