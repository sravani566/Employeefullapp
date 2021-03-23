package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.empapp.model.dao.Employee;
import com.empapp.model.service.EmployeeService;


@SpringBootApplication
public class Empapp2Application implements CommandLineRunner{

	@Autowired
	private EmployeeService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(Empapp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * System.out.println("rec are saved..."); empService.save(new Employee("Pooja",
		 * 33)); empService.save(new Employee("Sravani", 30)); empService.save(new
		 * Employee("Priyanka", 40)); empService.save(new Employee("Pavani", 45));
		 */	
	}
}

