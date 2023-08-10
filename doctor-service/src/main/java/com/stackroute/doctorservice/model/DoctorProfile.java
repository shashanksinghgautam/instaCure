package com.stackroute.doctorservice.model;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document ("DoctorProfile")
@Data
public class DoctorProfile {
    @Id
    @Column(name="id" , nullable = false)
    private int id;

    private String gender;
    private String address;
    private String dob;
    private String city;
    private String state;
    private int postalCode;
    private String educationQualifiaction;
    private String speciality;
    private String yearOfExpertise;
    private Binary dp;
    private byte image[];
    private UserEntity user;

    public DoctorProfile() {
    }

    public DoctorProfile(int id, String gender, String address, String dob, String city,
                         String state, int postalCode, String educationQualifiaction,
                         String speciality, String yearOfExpertise, Binary dp) {
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.educationQualifiaction = educationQualifiaction;
        this.speciality = speciality;
        this.yearOfExpertise = yearOfExpertise;
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

    public String getEducationQualifiaction() {
        return educationQualifiaction;
    }

    public void setEducationQualifiaction(String educationQualifiaction) {
        this.educationQualifiaction = educationQualifiaction;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getYearOfExpertise() {
        return yearOfExpertise;
    }

    public void setYearOfExpertise(String yearOfExpertise) {
        this.yearOfExpertise = yearOfExpertise;
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
}
