package com.stackroute.consultation.entity;


import java.time.LocalDateTime;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "PatientSymptoms")
public class PatientSymptoms {

    private String symptoms;


    private String mobilenumber;

    private String specality;


    public String getSpecality() {
        return specality;
    }

    public void setSpecality(String specality) {
        this.specality = specality;
    }

    public PatientSymptoms(String symptoms, String mobilenumber,String specality) {
        super();
        this.symptoms = symptoms;
        this.mobilenumber = mobilenumber;
        this.specality =specality;
    }

    public PatientSymptoms() {
        super();

    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }


}
