package com.stackroute.model;
public class UserEntity {

    private int id;
    private String uname;
    private String password;
    private String email;
    private String mobile;
    private String role;

    public UserEntity(int id, String uname, String password, String email, String mobile, String role) {

        this.id = id;
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.role = role;
    }

    public UserEntity() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", role='" + role + '\'' +
                '}';
    }
}
