package com.wecare.coachservice.service;

import com.wecare.coachservice.domain.Coach;
import com.wecare.coachservice.dto.CoachDTO;
import com.wecare.coachservice.repository.CoachRepository;
import com.wecare.coachservice.request.LoginRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = new Coach();
        BeanUtils.copyProperties(coachDTO, coach);
        Coach savedCoach = coachRepository.save(coach);
        BeanUtils.copyProperties(savedCoach, coachDTO);
        return coachDTO;
    }

    @Override
    public CoachDTO findCoachById(String coachId) {
        CoachDTO coachDTO = new CoachDTO();
        Coach coach= coachRepository.findById(coachId).orElse(new Coach());
        BeanUtils.copyProperties(coach,coachDTO);
        return coachDTO;
    }

    @Override
    public Optional<CoachDTO> validateCredentials(LoginRequest loginRequest) {
        Optional<Coach> coach = coachRepository.findByMobileAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        CoachDTO coachDTO = new CoachDTO();
        if(coach.isPresent()){
            BeanUtils.copyProperties(coach,coachDTO);
            return Optional.of(coachDTO);
        }
        return Optional.empty();
    }
}
