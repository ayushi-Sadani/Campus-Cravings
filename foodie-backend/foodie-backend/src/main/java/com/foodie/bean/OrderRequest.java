package com.foodie.bean;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private List<Long> itemIds;
}