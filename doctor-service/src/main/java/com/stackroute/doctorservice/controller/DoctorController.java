package com.stackroute.doctorservice.controller;


import java.io.IOException;
import java.util.List;

import com.stackroute.doctorservice.execptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.doctorservice.model.DoctorProfile;
import com.stackroute.doctorservice.repository.DoctorRepository;
import com.stackroute.doctorservice.service.DoctorService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @Autowired
    private DoctorRepository VolunteerRepo;

    @GetMapping("welcome")
    public String welcome() {
        return "this is my Doctor api";
    }

    @PostMapping("add")
    public ResponseEntity<DoctorProfile> addNewHandler(@RequestBody DoctorProfile DoctorProfile) {
        return new ResponseEntity<DoctorProfile>(service.addNew(DoctorProfile), HttpStatus.CREATED);

    }

    @PutMapping("DoctorProfile/{id}")
    public ResponseEntity<DoctorProfile> updateVolunteer(@PathVariable(value = "id") int Id, @Validated @RequestBody DoctorProfile Doctor) throws ResourceNotFoundException {
        DoctorProfile DoctorProfile = VolunteerRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + Id));


        DoctorProfile.setAddress(Doctor.getAddress());
        DoctorProfile.setCity(Doctor.getCity());
        DoctorProfile.setState(Doctor.getState());
        DoctorProfile.setPostalCode(Doctor.getPostalCode());
        DoctorProfile.setDob(Doctor.getDob());
        DoctorProfile.setEducationQualifiaction(Doctor.getEducationQualifiaction());
        DoctorProfile.setYearOfExpertise(Doctor.getYearOfExpertise());
        DoctorProfile.setSpeciality(Doctor.getSpeciality());
        final DoctorProfile DoctorProfile1 = VolunteerRepo.save(DoctorProfile);
        return ResponseEntity.ok(DoctorProfile1);
    }


    @GetMapping("/get")
    public List<DoctorProfile> getAllDoctors() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DoctorProfile> get(@PathVariable(value = "id") int id) {
        DoctorProfile doctor = this.service.getById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PutMapping("Doctor/image/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int Id,
                                    @RequestBody MultipartFile imgFile
    ) throws IOException, ResourceNotFoundException {

        System.out.println("inside image post");
        DoctorProfile Volunteer = VolunteerRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + Id));
        Volunteer.setImage(imgFile.getBytes());
        final DoctorProfile updatedVolunteer = VolunteerRepo.save(Volunteer);
        return ResponseEntity.status(HttpStatus.OK).body("file uploaded successfully : ");
    }


    @GetMapping("Doctor/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable(value = "id") int Id) throws ResourceNotFoundException {
//		byte[] imageData=service.downloadImage(Id);
        DoctorProfile dbImageData = VolunteerRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + Id));
        ;
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dbImageData.getImage());

    }

}
