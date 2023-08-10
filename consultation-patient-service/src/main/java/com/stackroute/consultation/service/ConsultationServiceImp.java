package com.stackroute.consultation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.consultation.entity.PatientSymptoms;
import com.stackroute.consultation.repository.ConsultationRepository;



@Service
public class ConsultationServiceImp implements ConsultationService {

    private ConsultationRepository crepo;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository crepo) {
        super();
        this.crepo=crepo;
        // TODO Auto-generated constructor stub
    }

    @Override
    public PatientSymptoms save(PatientSymptoms symptom) {
        // TODO Auto-generated method stub
        return this.crepo.save(symptom);
    }
}
