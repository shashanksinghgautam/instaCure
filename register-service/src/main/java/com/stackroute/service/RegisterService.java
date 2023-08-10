package com.stackroute.service;

import com.stackroute.model.UserEntity;
import com.stackroute.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository repo;
    public UserEntity saveUser(UserEntity newUser) {
        return this.repo.save(newUser);
    }

    public UserEntity getByEmail(String email){
        return repo.findByEmail(email);
    }
    public UserEntity getByMobile(String mobile){
        return repo.findByMobile(mobile);
    }

    public UserEntity getByEmailAndPasswordAndRole(String email, String password, String role){
        return repo.findByEmailAndPasswordAndRole(email,password,role);
    }
}
