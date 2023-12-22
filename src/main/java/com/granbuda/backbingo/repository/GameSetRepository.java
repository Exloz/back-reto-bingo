package com.granbuda.backbingo.repository;

import com.granbuda.backbingo.model.GameSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSetRepository extends MongoRepository<GameSet, String> {
}
