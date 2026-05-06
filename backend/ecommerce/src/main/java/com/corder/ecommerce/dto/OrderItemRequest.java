package com.corder.ecommerce.dto;

public record OrderItemRequest(
        Integer productId,
        Integer quantity
) {}
