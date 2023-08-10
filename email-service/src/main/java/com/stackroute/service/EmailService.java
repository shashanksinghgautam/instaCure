package com.stackroute.service;


import com.stackroute.model.Email;
import com.stackroute.model.UserEntity;

import java.util.List;


public interface EmailService {

    public void sendEmail(Email email, List<UserEntity> list);
}

