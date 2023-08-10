package com.stackroute.consultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.consultation.entity.PatientSymptoms;
import com.stackroute.consultation.repository.ConsultationRepository;
import com.stackroute.consultation.service.ConsultationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("consult/")
public class ConsultationController {

    @Autowired
    private ConsultationRepository crepo;

    private ConsultationService cservice;

    @GetMapping("welcome")
    public String welcome() {
        return "this is my Consultation api";
    }

    @Autowired
    public ConsultationController(ConsultationService cservice) {
        super();
        this.cservice = cservice;
    }

    @GetMapping("symptoms")
    public List<PatientSymptoms> getall() {
        return crepo.findAll();
    }

    @PostMapping("saveSymptoms")
    public ResponseEntity<PatientSymptoms> saveSymptoms(@RequestBody PatientSymptoms symptom) {
        PatientSymptoms s = this.cservice.save(symptom);
        return new ResponseEntity<PatientSymptoms>(s, HttpStatus.OK);
    }

}
