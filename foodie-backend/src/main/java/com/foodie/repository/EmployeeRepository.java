package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodie.model.Employee;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsernameAndPassword(String username, String password);
}