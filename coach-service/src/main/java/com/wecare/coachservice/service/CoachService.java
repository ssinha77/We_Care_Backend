package com.wecare.coachservice.service;

import com.wecare.coachservice.dto.CoachDTO;
import com.wecare.coachservice.request.LoginRequest;

import java.util.Optional;

public interface CoachService {
    CoachDTO createCoach(CoachDTO coachDTO);

    CoachDTO findCoachById(String coachId);

    Optional<CoachDTO> validateCredentials(LoginRequest loginRequest);
}
