package com.beshmart.microservices.order.service;

import com.beshmart.microservices.order.client.InventoryClient;
import com.beshmart.microservices.order.dto.OrderRequest;
import com.beshmart.microservices.order.model.Order;
import com.beshmart.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            //map OrderRequest to Order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            //save order to OrderRepository
            orderRepository.save(order);

        } else {
            throw new RuntimeException("Sorry " + orderRequest.skuCode() + "is not in stock!");
        }


    }
}
