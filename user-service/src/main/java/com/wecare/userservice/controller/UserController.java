package com.wecare.userservice.controller;

import com.wecare.userservice.dto.UserDTO;
import com.wecare.userservice.request.LoginRequest;
import com.wecare.userservice.security.Authorised;
import com.wecare.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{userId}")
    @Authorised(roles = "USER", selfCheck = true)
    public ResponseEntity<UserDTO> getUser(@RequestHeader(value = "Authorization") String authorization,@PathVariable String userId) {
        UserDTO response = userService.getUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<Optional<UserDTO>> validateCredentials(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(userService.validateCredentials(loginRequest.getUsername(), loginRequest.getPassword()),HttpStatus.OK);
    }
}
