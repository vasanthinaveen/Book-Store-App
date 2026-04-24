package com.example.book_store.repository;

import com.example.book_store.entity.userInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface userInfoRepo extends MongoRepository<userInfo,String> {
    //Optional<userInfo> findByUsername(String userName);
}
