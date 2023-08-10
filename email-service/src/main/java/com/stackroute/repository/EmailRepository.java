package com.stackroute.repository;

import com.stackroute.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends MongoRepository<Email,Integer> {
    public Email findBySubject(String subject);

    void deleteBySubject(String subject);
}
