package com.stackroute.controller;

import com.stackroute.consumerRabbitMq.MessageListener;
import com.stackroute.exceptions.ResourceNotFoundException;
import com.stackroute.model.Email;
import com.stackroute.model.UserEntity;
import com.stackroute.repository.EmailRepository;
import com.stackroute.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository repo;

    @Autowired
    private MessageListener ml;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping ("welcome")
    public String welcome(){
        return "this is my email api";
    }

    @PostMapping("/send")
    public ResponseEntity<?>sendEmail(@RequestBody Email email){
        repo.save(email);
        List<UserEntity>list= ml.getEmailList();
        System.out.println(list.toString());
        this.emailService.sendEmail(email,list);
        email.setTo("VOLUNTEERs");
        System.out.println(email);
        return ResponseEntity.ok("successfully sent => "+email.getTo());
    }

    @GetMapping("/allMails")
    public List<Email> getAllMails(){
        List<Email> list=repo.findAll();
        return list;
    }

    @DeleteMapping("deletemail/{subject}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "subject") String subject)
            throws ResourceNotFoundException {
        Email Medicine = repo.findBySubject(subject);
        System.out.println(Medicine.toString()+ "Dletedddd");
        repo.deleteBySubject(subject);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
