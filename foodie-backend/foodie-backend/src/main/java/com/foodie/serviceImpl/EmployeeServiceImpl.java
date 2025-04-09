package com.foodie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodie.model.Employee;
import com.foodie.repository.EmployeeRepository;
import com.foodie.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean validateLogin(String username, String password) {
        return employeeRepository.findByUsernameAndPassword(username, password).isPresent();
    }
}