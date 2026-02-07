package com.beshmart.microservices.order.repository;

import com.beshmart.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long > {
}
