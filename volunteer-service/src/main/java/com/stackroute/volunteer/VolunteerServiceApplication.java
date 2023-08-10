package com.stackroute.volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.stackroute.volunteer.repository.VolunteerRepository;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
@EnableEurekaClient
public class VolunteerServiceApplication implements CommandLineRunner{
	
	 	@Autowired
	  VolunteerRepository volrep;
	 
	public static void main(String[] args) {
		SpringApplication.run(VolunteerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
