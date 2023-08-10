package com.stackroute.volunteer.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.volunteer.config.ImageUtils;
import com.stackroute.volunteer.model.Volunteer;
import com.stackroute.volunteer.repository.VolunteerRepository;

@Service
public class VolunteerServiceImpl implements VolunteerService{

	
	VolunteerRepository VolunteerRepository;

	
	private VolunteerRepository repo;

	@Autowired
	public VolunteerServiceImpl(VolunteerRepository repo) {
		super();
//		System.out.println(repo);
		this.repo = repo;
	}

	@Override
	public List<Volunteer> getAll() {
//		System.out.println(repo.findAll());
		return (List<Volunteer>) repo.findAll();
	}

	@Override
	public Volunteer addNew(Volunteer emp) {
		
		Optional<Volunteer> Medicine = repo.findById(0);
		if (Medicine.isPresent()) {
			System.out.println("Duplicate");
			return null;
		} else {
			return repo.save(emp);
		}
	}

	@Override
	public Volunteer getById(int id) {
		Optional<Volunteer> Volunteer = repo.findById(id);
		if (Volunteer.isPresent()) {
			
			return Volunteer.get();
		} else {
			
			System.out.println("not found");
			return null;
		}
	}
	
	
}
