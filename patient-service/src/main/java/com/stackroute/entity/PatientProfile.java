package com.stackroute.entity;


import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

import javax.persistence.Id;

@Document("PatientProfile")
public class PatientProfile {
    @Id
    private int id;
    private String address;
    private String dob;
    private String gender;
    private String city;
    private int postalCode;
    private byte[] image ;
    private UserEntity user;
    public PatientProfile() {
    }

    public PatientProfile(int id, String gender, String address, String dob, String city, int postalCode, byte[] image, UserEntity user) {
        this.id = id;
        this.address = address;
        this.dob = dob;
        this.city = city;
        this.postalCode = postalCode;
        this.image = image;
        this.user = user;
        this.gender=gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
