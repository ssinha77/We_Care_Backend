package com.wecare.userservice.client;

import com.wecare.userservice.dto.UserDTO;
import com.wecare.userservice.request.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient(name = "user-service", path = "/api/users")
public interface UserClient {

    @PostMapping
    public UserDTO create(@RequestBody @Valid UserDTO userDTO);

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String userId);

    @PostMapping("/validate")
    public ResponseEntity<Optional<UserDTO>> validateCredentials(@RequestBody LoginRequest loginRequest);
    }
