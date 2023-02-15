package com.wecare.iamservice.client;

import com.wecare.iamservice.dto.UserDTO;
import com.wecare.iamservice.response.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient(name = "user-service", path = "/api/users")
public interface UserClient {

    @PostMapping
    public UserDTO create(@RequestBody @Valid UserDTO userDTO);

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@RequestHeader(value = "Authorization") String authorization, @PathVariable String userId);
    @PostMapping("/validate")
    public ResponseEntity<Optional<UserDTO>> validateCredentials(@RequestBody LoginRequest loginRequest);

}
