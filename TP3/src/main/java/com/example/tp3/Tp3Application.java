package com.example.tp3;

import com.example.tp3.Repositories.PatientRepository;
import com.example.tp3.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);

	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(0L, "hassna",new Date(), false,100));
			patientRepository.save(
					new Patient(1L, "somin",new Date(),false,80));
			patientRepository.save(
					new Patient(2L, "hassaaan",new Date(),false,95));
			patientRepository.save(
					new Patient(3L, "jahn", new Date(),true,77));
			patientRepository.save(
					new Patient(4L, "hamid",new Date(),true,85));
			};
		};
	}
