package com.stackroute.consultation.repository;

import com.stackroute.consultation.entity.PatientSymptoms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends MongoRepository<PatientSymptoms,Integer> {

}
