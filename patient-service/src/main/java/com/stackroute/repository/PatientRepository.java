package com.stackroute.repository;

import com.stackroute.entity.PatientProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<PatientProfile, Integer> {
}
