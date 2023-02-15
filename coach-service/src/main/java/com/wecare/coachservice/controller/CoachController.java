package com.wecare.coachservice.controller;

import com.wecare.coachservice.client.CoachClient;
import com.wecare.coachservice.dto.CoachDTO;
import com.wecare.coachservice.request.LoginRequest;
import com.wecare.coachservice.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public CoachDTO create(@RequestBody @Valid CoachDTO coach) {
        return coachService.createCoach(coach);
    }

    @GetMapping
    public String get() {
        return "Get Mapping";
    }

    @GetMapping("/{coachId}")
    public CoachDTO getCoach(@PathVariable String coachId){
        return coachService.findCoachById(coachId);
    }

    @PostMapping("/validate")
    public Optional<CoachDTO> validateCoach(@RequestBody LoginRequest loginRequest){
        return coachService.validateCredentials(loginRequest);
    }
}
