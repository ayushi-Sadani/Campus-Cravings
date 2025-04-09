package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodie.model.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
