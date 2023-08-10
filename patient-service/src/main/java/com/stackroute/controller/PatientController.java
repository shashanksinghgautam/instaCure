package com.stackroute.controller;


import java.io.IOException;
import java.util.List;
import com.stackroute.execptions.ResourceNotFoundException;
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

import com.stackroute.entity.PatientProfile;

import com.stackroute.repository.PatientRepository;
import com.stackroute.service.PatientService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientService service;
    @Autowired
    private PatientRepository Repo;

    @GetMapping("/welcome")
    public String welcome() {

        return "Hello Patient........";
    }

	@PostMapping("add")
    public ResponseEntity<PatientProfile> addNewHandler(@RequestBody PatientProfile PatientProfile) {
			return new ResponseEntity<PatientProfile>(service.addNew(PatientProfile), HttpStatus.CREATED);
		

}
	@PutMapping("/patient/{id}")
	public ResponseEntity<PatientProfile> updateVolunteer(@PathVariable(value = "id") int Id,@Validated @RequestBody PatientProfile user) throws ResourceNotFoundException {
		PatientProfile PatientProfile = Repo.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + Id));

		PatientProfile.setAddress(user.getAddress());
        PatientProfile.setDob(user.getDob());
		PatientProfile.setCity(user.getCity());
		PatientProfile.setPostalCode(user.getPostalCode());
		final PatientProfile updatedPatient = Repo.save(PatientProfile);
		return ResponseEntity.ok(updatedPatient);
	}
    @GetMapping("/get")
    public List<PatientProfile> getAllPatients() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PatientProfile> get(@PathVariable(value = "id") int id) {
        PatientProfile patient = this.service.getById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping("Patient/image/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int Id,
                                    @RequestBody MultipartFile imgFile
    ) throws IOException, ResourceNotFoundException {

        System.out.println("inside image post");
        PatientProfile Volunteer = Repo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + Id));
        Volunteer.setImage(imgFile.getBytes());
        final PatientProfile updatedVolunteer = Repo.save(Volunteer);
        return ResponseEntity.status(HttpStatus.OK).body("file uploaded successfully : ");
    }


    @GetMapping("Patient/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable(value = "id") int Id) throws ResourceNotFoundException {
//		byte[] imageData=service.downloadImage(Id);
        PatientProfile dbImageData = Repo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + Id));
        ;
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dbImageData.getImage());

    }

}
