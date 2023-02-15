package com.wecare.coachservice.repository;

import com.wecare.coachservice.domain.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoachRepository extends MongoRepository<Coach,String> {
    Optional<Coach> findByMobileAndPassword(String mobile, String password);
}
