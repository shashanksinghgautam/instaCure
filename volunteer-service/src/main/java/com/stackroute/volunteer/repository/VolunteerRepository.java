package com.stackroute.volunteer.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.stackroute.volunteer.model.Volunteer;

@Repository
public interface VolunteerRepository extends MongoRepository<Volunteer, Integer> {

	

	
}
