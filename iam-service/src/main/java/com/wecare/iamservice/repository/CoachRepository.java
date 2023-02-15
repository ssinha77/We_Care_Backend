package com.wecare.iamservice.repository;

import com.wecare.iamservice.domain.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoachRepository extends MongoRepository<Coach,String> {
    Coach findByMobileAndPassword(String mobile, String password);
}
