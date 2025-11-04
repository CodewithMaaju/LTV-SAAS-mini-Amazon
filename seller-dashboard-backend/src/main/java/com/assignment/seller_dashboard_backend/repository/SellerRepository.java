package com.assignment.seller_dashboard_backend.repository;

import com.assignment.seller_dashboard_backend.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
