package com.stackroute.volunteer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.volunteer.config.UserConfiguration;
import com.stackroute.volunteer.execptions.ResourceNotFoundException;
import com.stackroute.volunteer.model.Volunteer;
import com.stackroute.volunteer.repository.VolunteerRepository;
import com.stackroute.volunteer.service.VolunteerService;
import com.stackroute.volunteer.template.UserEntity;

import java.util.Optional;

@Component
public class MessageListener {

    @Autowired
    private VolunteerRepository VolunteerRepo;

    @Autowired
    private VolunteerService VolunteerService;

    @RabbitListener(queues = "vol_queue")
    public void listener(UserEntity newUser) throws ResourceNotFoundException {
        if (newUser.getRole().contains("Volunteer")) {
            if (!VolunteerRepo.findById(newUser.getId()).isPresent()) {
                Volunteer Vol = new Volunteer();
                System.out.println(newUser.getUname());
                Vol.setVid(newUser.getId());
                Vol.setUser(newUser);
                final Volunteer updatedVol = VolunteerRepo.save(Vol);
            } else {
                Optional<Volunteer> Vol = VolunteerRepo.findById(newUser.getId());
                Vol.get().setVid(newUser.getId());
                Vol.get().setUser(newUser);
                VolunteerRepo.save(Vol.get());
                System.out.println(newUser.getEmail());
            }
        }
    }
}