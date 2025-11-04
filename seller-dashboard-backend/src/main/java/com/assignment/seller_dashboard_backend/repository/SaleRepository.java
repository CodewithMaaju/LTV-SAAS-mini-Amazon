package com.assignment.seller_dashboard_backend.repository;

import com.assignment.seller_dashboard_backend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

  
    List<Sale> findBySeller_Id(Integer sellerId);
}
