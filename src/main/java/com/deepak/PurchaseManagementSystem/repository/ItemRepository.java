package com.deepak.PurchaseManagementSystem.repository;

import com.deepak.PurchaseManagementSystem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT MAX(i.id) FROM Item i")
    Long findMaxId();
}
