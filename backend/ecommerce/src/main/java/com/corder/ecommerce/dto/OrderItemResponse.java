package com.corder.ecommerce.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String productName,
        Integer quantity,
        BigDecimal totalPrice
) {
}
