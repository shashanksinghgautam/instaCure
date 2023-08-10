package com.stackroute.productwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class controller {
    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }

}
