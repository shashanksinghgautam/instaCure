package com.stackroute.consultation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsultationPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultationPatientServiceApplication.class, args);
	}

}
