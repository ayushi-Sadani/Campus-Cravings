package com.foodie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.foodie.model.Employee;
import com.foodie.repository.EmployeeRepository;

@SpringBootApplication
public class FoodieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieBackendApplication.class, args);
	}
@Bean
public CommandLineRunner seedEmployee(EmployeeRepository employeeRepo) {
    return args -> {
        if (employeeRepo.count() == 0) {
            employeeRepo.save(new Employee(null, "admin", "admin"));
        }
    };
}
}
