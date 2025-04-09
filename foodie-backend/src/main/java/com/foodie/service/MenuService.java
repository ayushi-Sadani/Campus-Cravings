package com.foodie.service;
import java.util.List;
import com.foodie.model.MenuItem;
public interface MenuService {
    List<MenuItem> getAllMenuItems();
    void seedMenu();
}
