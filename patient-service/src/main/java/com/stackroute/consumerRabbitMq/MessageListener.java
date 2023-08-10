package com.stackroute.consumerRabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stackroute.entity.PatientProfile;
import com.stackroute.entity.UserEntity;
import com.stackroute.repository.PatientRepository;

import java.util.Optional;

@Component
public class MessageListener {
    @Autowired
    private PatientRepository PatientRepo;

    @RabbitListener(queues = "pat_queue")
    public void listener(UserEntity newUser) {

        if (newUser.getRole().equals("Patient")) {

            if (!PatientRepo.findById(newUser.getId()).isPresent()) {

                PatientProfile Patient = new PatientProfile();
                System.out.println(newUser.getUname());
                Patient.setId(newUser.getId());
                Patient.setUser(newUser);
                final PatientProfile updatedPatient = PatientRepo.save(Patient);
            }
            else {
                Optional<PatientProfile> Patient = PatientRepo.findById(newUser.getId());
                Patient.get().setId(newUser.getId());
                Patient.get().setUser(newUser);
                PatientRepo.save(Patient.get());
                System.out.println(newUser.getEmail());
            }
        }

    }
}