/*
package com.stackroute.doctorservice.consumerRabbitMq;

import com.stackroute.doctorservice.model.DoctorProfile;
import com.stackroute.doctorservice.model.UserEntity;
import com.stackroute.doctorservice.service.DoctorService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileConsumer {

    private UserEntity User;
    
    @Autowired
    private DoctorService service;

    @RabbitListener(queues = "user_queue")
    public void getUserFromQueue(UserEntity user) {
        this.User = user;
        System.out.println(user);
       */
/* if(user.getRole().equals("Doctor")) {
        	DoctorProfile doc = new DoctorProfile();
            doc.setUser(user);
            doc.setId(user.getId());
            DoctorProfile doctor = this.service.addNew(doc);}*//*

    }

    public UserEntity returnUserToProfile() {

        return User;
    }

}
*/
