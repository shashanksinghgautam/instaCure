package com.stackroute.doctorservice.repository;

import com.stackroute.doctorservice.model.DoctorProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<DoctorProfile, Integer>  {

}
