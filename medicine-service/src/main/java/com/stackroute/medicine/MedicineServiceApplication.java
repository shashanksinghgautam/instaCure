package com.stackroute.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.stackroute.medicine.model.Medicine;
import com.stackroute.medicine.repository.MedicineRepository;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
@EnableEurekaClient
public class MedicineServiceApplication implements CommandLineRunner{

	  @Autowired
	  MedicineRepository medrep;
	public static void main(String[] args) {
		SpringApplication.run(MedicineServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
	}

}
