package com.stackroute.service;

import com.stackroute.entity.PatientProfile;
import com.stackroute.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<PatientProfile> getAll() {
        return repo.findAll();
    }

    public PatientProfile addNew(PatientProfile patient) {
        return repo.save(patient);
    }

    public PatientProfile getById(int id) {
        Optional<PatientProfile> profile = repo.findById(id);
        return profile.get();
    }

}
