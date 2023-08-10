package com.stackroute.consultation.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
public class DoctorProfile {

    private int id;

    private String gender;
    private String address;
    private String dob;
    private String city;
    private String state;
    private int postalCode;
    private String educationqualification;
    private String speciality;
    private String yearofexpertise;
    private Binary dp;
    //private byte doc[];
    private UserEntity user;

    public DoctorProfile() {
    }

    public DoctorProfile(int id, String gender, String address, String dob, String city,
                         String state, int postalCode, String educationqualification,
                         String speciality, String yearofexpertise, Binary dp) {
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.educationqualification = educationqualification;
        this.speciality = speciality;
        this.yearofexpertise = yearofexpertise;
        this.dp = dp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEducationqualification() {
        return educationqualification;
    }

    public void setEducationqualification(String educationqualification) {
        this.educationqualification = educationqualification;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getYearofexpertise() {
        return yearofexpertise;
    }

    public void setYearofexpertise(String yearofexpertise) {
        this.yearofexpertise = yearofexpertise;
    }

    public Binary getDp() {
        return dp;
    }

    public void setDp(Binary dp) {
        this.dp = dp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
