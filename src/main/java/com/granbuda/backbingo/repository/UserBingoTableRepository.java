package com.granbuda.backbingo.repository;

import com.granbuda.backbingo.model.UserBingoTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBingoTableRepository extends MongoRepository<UserBingoTable, String> {
}
