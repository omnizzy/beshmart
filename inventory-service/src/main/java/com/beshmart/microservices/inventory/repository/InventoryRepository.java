package com.beshmart.microservices.inventory.repository;

import com.beshmart.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySKuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
