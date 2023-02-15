package com.wecare.userservice.service;

import com.wecare.userservice.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(String userId);

    Optional<UserDTO> validateCredentials(String mobile,String password);
}
