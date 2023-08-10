package com.stackroute.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.stackroute.model.UserEntity;
import com.stackroute.rabbitMQconfig.UserConfiguration;
import com.stackroute.repository.RegisterRepository;
import com.stackroute.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reg")
@CrossOrigin(origins = "*")
public class RegisterController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterRepository repo;

    @GetMapping("/welcome")
    public String welcome() {

        return "Hello Register........";
    }

    @PostMapping("register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity newUser) throws Exception {

        // Cheking for existing User by email, if found then throw exception
        String tempEmail = newUser.getEmail();
        if (tempEmail != null && !tempEmail.isEmpty()) {
            UserEntity user = registerService.getByEmail(tempEmail);
            if (user != null) {
                throw new Exception("This Email Already Exists");
            }
        }

        // Cheking for existing User by mobile, if found then throw exception
        String tempMobile = newUser.getMobile();
        if (tempMobile.isEmpty()) {
            UserEntity user = registerService.getByMobile(tempMobile);
            if (user != null) {
                throw new Exception("This Mobile Already Exists");
            }
        }

        // If not present then storing it in Db.
        UserEntity user = this.registerService.saveUser(newUser);

        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
    }


    @PostMapping("login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user) throws Exception {

        String tempEmail = user.getEmail(), tempPass = user.getPassword(), tempRole = user.getRole();

        UserEntity tempUser = null;
        if (tempEmail != null && tempPass != null && tempRole != null) {
            tempUser = registerService.getByEmailAndPasswordAndRole(tempEmail, tempPass, tempRole);
            // System.out.println(tempUser.getId());
        }
        if (tempUser == null) {
            throw new Exception("User Doesn't Exist");
        }
        template.convertAndSend(UserConfiguration.EXCHANGE, "", tempUser);
        return new ResponseEntity<UserEntity>(tempUser, HttpStatus.OK);
    }

    @PostMapping("user")
    public int getuserid(@RequestBody UserEntity user) throws Exception {

        String tempEmail = user.getEmail(), tempPass = user.getPassword(), tempRole = user.getRole();

        UserEntity tempUser = null;
        if (tempEmail != null && tempPass != null && tempRole != null) {
            tempUser = registerService.getByEmailAndPasswordAndRole(tempEmail, tempPass, tempRole);
            // System.out.println(tempUser.getId());
        }
        if (tempUser == null) {
            throw new Exception("User Doesn't Exist");
        }
        return tempUser.getId();
    }

    @PostMapping("role")
    public String getuserrole(@RequestBody UserEntity user) throws Exception {

        String tempEmail = user.getEmail(), tempPass = user.getPassword(), tempRole = user.getRole();

        UserEntity tempUser = null;
        if (tempEmail != null && tempPass != null && tempRole != null) {
            tempUser = registerService.getByEmailAndPasswordAndRole(tempEmail, tempPass, tempRole);
            // System.out.println(tempUser.getId());
        }
        if (tempUser == null) {
            throw new Exception("User Doesn't Exist");
        }
        return tempUser.getRole();
    }

    @GetMapping("Volunteer/email")
    public ResponseEntity<?> getallemail() {

        List<UserEntity> all = this.repo.findAll();
        List<UserEntity> vol = new ArrayList<>();

        for (UserEntity v : all) {
            if (v.getRole().equals("Volunteer"))
                vol.add(v);
        }
        System.out.println(vol);
        template.convertAndSend(UserConfiguration.EXCHANGE, "", vol);
        return new ResponseEntity<>(vol, HttpStatus.OK);
    }

}
