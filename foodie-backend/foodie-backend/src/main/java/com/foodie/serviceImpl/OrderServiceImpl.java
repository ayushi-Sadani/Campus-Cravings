package com.foodie.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import com.foodie.service.OrderService;
import com.foodie.model.MenuItem;
import com.foodie.model.FoodOrder;
import com.foodie.repository.FoodOrderRepository;
import com.foodie.repository.MenuItemRepository;
import com.foodie.bean.OrderRequest;
import com.foodie.bean.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private FoodOrderRepository orderRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
public OrderResponse placeOrder(OrderRequest request) {
    List<MenuItem> items = menuRepo.findAllById(request.getItemIds());

    if (items.isEmpty()) {
        throw new RuntimeException("No valid menu items found for the given IDs");
    }

    List<String> itemNames = items.stream()
                                  .map(MenuItem::getName)
                                  .collect(Collectors.toList());

    double totalPrice = items.stream()
                             .mapToDouble(MenuItem::getPrice)
                             .sum();

    FoodOrder order = new FoodOrder();
    order.setItemsJson(itemNames.toString()); // saves as ["Burger", "Pizza"]
    order.setTotalPrice(totalPrice);

    FoodOrder savedOrder = orderRepo.save(order);

    return new OrderResponse(savedOrder.getId(), "Order placed successfully");
}
@Override
    public List<FoodOrder> getAllOrders() {
        return orderRepo.findAll();
    }
}

