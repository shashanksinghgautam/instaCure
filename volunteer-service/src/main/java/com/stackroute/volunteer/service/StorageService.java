package com.stackroute.volunteer.service;



import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.volunteer.config.ImageUtils;
import com.stackroute.volunteer.execptions.ResourceNotFoundException;

import com.stackroute.volunteer.model.Volunteer;
import com.stackroute.volunteer.repository.VolunteerRepository;

@Service
public class StorageService {

    @Autowired
    private VolunteerRepository repository;

    

    public byte[] downloadImage(int ID) throws ResourceNotFoundException{
        Volunteer dbImageData = repository.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id :: " + ID));;
        byte[] images=ImageUtils.decompressImage(dbImageData.getImage());
        return images;
    }
  
}