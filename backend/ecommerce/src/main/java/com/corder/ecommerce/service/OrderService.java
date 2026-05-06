package com.corder.ecommerce.service;

import com.corder.ecommerce.dto.OrderRequest;
import com.corder.ecommerce.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    public OrderResponse placeOrder(OrderRequest request);
    public List<OrderResponse> getAllOrderResponses();
}
