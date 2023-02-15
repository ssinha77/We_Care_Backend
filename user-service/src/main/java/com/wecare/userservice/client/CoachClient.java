package com.wecare.userservice.client;

import com.wecare.userservice.dto.CoachDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "coach-service")
public interface CoachClient {

    @PostMapping("/api/coaches")
    CoachDTO create(@RequestBody @Valid CoachDTO coach);

    @GetMapping("/api/coaches")
    public String get();

}
