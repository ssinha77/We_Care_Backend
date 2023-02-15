package com.wecare.iamservice.client;


import com.wecare.iamservice.dto.CoachDTO;
import com.wecare.iamservice.response.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient(name = "coach-service")
public interface CoachClient {

    @PostMapping("/api/coaches")
    CoachDTO create(@RequestBody @Valid CoachDTO coach);
    @GetMapping("/api/coaches")
    public String get();

    @PostMapping("/api/coaches/validate")
    public Optional<CoachDTO> validateCoach(@RequestBody LoginRequest loginRequest);
}
