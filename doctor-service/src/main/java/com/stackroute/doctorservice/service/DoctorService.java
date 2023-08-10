package com.stackroute.doctorservice.service;

import com.stackroute.doctorservice.model.DoctorProfile;

import com.stackroute.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;



    public List<DoctorProfile>  getAll() { return repo.findAll(); }

    public DoctorProfile addNew(DoctorProfile doctor) { return  repo.save(doctor); }

    public DoctorProfile getById(int id) {
        Optional<DoctorProfile> profile = repo.findById(id);
        return profile.get();
    }


    }
