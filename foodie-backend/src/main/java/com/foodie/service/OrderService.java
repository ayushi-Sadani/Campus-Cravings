package com.foodie.service;
import com.foodie.bean.OrderResponse;
import com.foodie.model.FoodOrder;

import java.util.List;

import com.foodie.bean.OrderRequest;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);

    List<FoodOrder> getAllOrders();
}
