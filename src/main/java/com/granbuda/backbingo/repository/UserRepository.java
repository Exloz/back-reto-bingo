package com.granbuda.backbingo.repository;

import com.granbuda.backbingo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
