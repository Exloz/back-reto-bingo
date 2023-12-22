package com.granbuda.backbingo.repository;

import com.granbuda.backbingo.model.UserBingoTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserBingoTableRepository extends MongoRepository<UserBingoTable, String> {
}
