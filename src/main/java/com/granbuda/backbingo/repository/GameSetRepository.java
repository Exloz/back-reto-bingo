package com.granbuda.backbingo.repository;

import com.granbuda.backbingo.model.GameSet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameSetRepository extends MongoRepository<GameSet, String> {
}
