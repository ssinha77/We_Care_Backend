package com.wecare.userservice.repository;


import com.wecare.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByMobileAndPassword(String mobile, String password);
}
