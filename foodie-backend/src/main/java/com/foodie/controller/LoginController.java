package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodie.service.EmployeeService;

import java.util.Map;

@CrossOrigin(origins = "*")  // Allow all origins
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        boolean valid = employeeService.validateLogin(username, password);

        if (valid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}