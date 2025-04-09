package com.foodie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.model.MenuItem;
import com.foodie.service.MenuService;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuItem> getMenu() {
        return menuService.getAllMenuItems();
    }

    @PostMapping("/seed")
    public ResponseEntity<String> seedMenu() {
        menuService.seedMenu();
        return ResponseEntity.ok("Menu seeded.");
    }
}