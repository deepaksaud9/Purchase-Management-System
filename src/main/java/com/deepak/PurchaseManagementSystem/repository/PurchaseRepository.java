package com.deepak.PurchaseManagementSystem.repository;

import com.deepak.PurchaseManagementSystem.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
