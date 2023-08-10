package com.stackroute.volunteer.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import com.stackroute.volunteer.execptions.ResourceNotFoundException;
import com.stackroute.volunteer.model.Volunteer;
import com.stackroute.volunteer.repository.VolunteerRepository;
import com.stackroute.volunteer.service.StorageService;
import com.stackroute.volunteer.service.VolunteerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class VolunteerController {
    @Autowired
    private VolunteerRepository VolunteerRepo;

    @Autowired
    private VolunteerService VolunteerService;

    @Autowired
    public VolunteerController(VolunteerService VolunteerService) {
        super();
        this.VolunteerService = VolunteerService;
    }

    public VolunteerController() {
        super();
    }

    @GetMapping("hello")
    public String welcome() {

        return "Hello Volunteer........";
    }

    @GetMapping("Volunteer")
    public List<Volunteer> getMedicine() {
        System.out.println(this.VolunteerRepo.findAll());
        return this.VolunteerRepo.findAll();
    }

    @GetMapping("Volunteer/{id}")
    public Volunteer getVolunteerById(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
// 		 System.out.println(id);

        Volunteer Volunteer = VolunteerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found for this id :: " + id));
        return Volunteer;
    }


    @PutMapping("Volunteer/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(@PathVariable(value = "id") int Id, @Validated @RequestBody Volunteer VolunteerDetails) throws ResourceNotFoundException {
        Volunteer Volunteer = VolunteerRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id :: " + Id));

        System.out.println(Volunteer.getState());
        Volunteer.setAddress(VolunteerDetails.getAddress());
        Volunteer.setCity(VolunteerDetails.getCity());
        System.out.println(Volunteer.getCity());
        Volunteer.setState(VolunteerDetails.getState());
        Volunteer.setZipcode(VolunteerDetails.getZipcode());
        Volunteer.getUser().setMobile(VolunteerDetails.getmobile());
//    	Volunteer.setVname(VolunteerDetails.getVname());
//    	Volunteer.setvemail(VolunteerDetails.getvemail());


        final Volunteer updatedVolunteer = VolunteerRepo.save(Volunteer);
        return ResponseEntity.ok(updatedVolunteer);
    }

    @PostMapping("Volunteer")
    public ResponseEntity<Volunteer> addNewHandler(@RequestBody Volunteer Volunteer) {
//    	System.out.println(MedicineService.getAll());

        return new ResponseEntity<Volunteer>(VolunteerService.addNew(Volunteer), HttpStatus.CREATED);


    }

    @Autowired
    private StorageService service;

    @PutMapping("Volunteer/image/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int Id,
                                    @RequestBody MultipartFile imgFile
    ) throws IOException, ResourceNotFoundException {

        System.out.println("inside image post");
        Volunteer Volunteer = VolunteerRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found for this id :: " + Id));
        Volunteer.setImage(imgFile.getBytes());
        final Volunteer updatedVolunteer = VolunteerRepo.save(Volunteer);
        return ResponseEntity.status(HttpStatus.OK).body("file uploaded successfully : ");
    }


    @GetMapping("Volunteer/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable(value = "id") int Id) throws ResourceNotFoundException {
//		byte[] imageData=service.downloadImage(Id);
        Volunteer dbImageData = VolunteerRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Volunteer not found for this id :: " + Id));
        ;
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dbImageData.getImage());

    }

   /* @PostMapping("/Email")
    public ResponseEntity<?> setMails(@RequestBody Email mail) {
        List<Volunteer> list = VolunteerRepo.findAll();
        List<Email> email = new ArrayList<>();

        for (Volunteer vol : list) {
            if (vol.getEmail() != null) {
                email = vol.getEmail();
            }
            email.add(mail);
            vol.setEmail(email);
        }
        return new ResponseEntity<>(mail,HttpStatus.OK);
    }*/

}
