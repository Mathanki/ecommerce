package com.corder.ecommerce.repository;

import com.corder.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
}
