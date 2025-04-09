package com.foodie.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.foodie.service.MenuService;
import com.foodie.repository.MenuItemRepository;
import com.foodie.model.MenuItem;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuRepo.findAll();
    }

    @Override
    public void seedMenu() {
        menuRepo.deleteAll();
        menuRepo.saveAll(List.of(
            new MenuItem(null, "Burger", 129, "https://plus.unsplash.com/premium_photo-1683619761468-b06992704398?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YnVyZ2VyfGVufDB8fDB8fHww"),
            new MenuItem(null, "Pizza", 249, "https://images.unsplash.com/photo-1604382354936-07c5d9983bd3?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cGl6emF8ZW58MHx8MHx8fDA%3D"),
            new MenuItem(null, "Pasta", 199, "https://images.unsplash.com/photo-1608897013039-887f21d8c804?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cGFzdGF8ZW58MHx8MHx8fDA%3D")
        ));
    }
}

