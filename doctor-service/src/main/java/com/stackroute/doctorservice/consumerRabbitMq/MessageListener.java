package com.stackroute.doctorservice.consumerRabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stackroute.doctorservice.model.DoctorProfile;
import com.stackroute.doctorservice.model.UserEntity;
import com.stackroute.doctorservice.repository.DoctorRepository;

import java.util.Optional;

@Component
public class MessageListener {

    @Autowired
    private DoctorRepository DoctorRepo;

    @RabbitListener(queues = "doc_queue")
    public void listener(UserEntity newUser) {
        if (newUser.getRole().equals("Doctor")) {
            if (!DoctorRepo.findById(newUser.getId()).isPresent()) {
                DoctorProfile Doctor = new DoctorProfile();
                System.out.println(newUser.getUname());
                Doctor.setId(newUser.getId());
                Doctor.setUser(newUser);
                final DoctorProfile updatedDoctor = DoctorRepo.save(Doctor);
            } else {
                Optional<DoctorProfile> Doctor = DoctorRepo.findById(newUser.getId());
                Doctor.get().setId(newUser.getId());
                Doctor.get().setUser(newUser);
                DoctorRepo.save(Doctor.get());
                System.out.println(newUser.getEmail());
            }

        }

    }
}