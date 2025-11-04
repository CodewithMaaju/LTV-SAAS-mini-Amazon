package com.assignment.seller_dashboard_backend.controller;

import com.assignment.seller_dashboard_backend.model.Seller;
import com.assignment.seller_dashboard_backend.model.SellerSummaryResponse;
import com.assignment.seller_dashboard_backend.repository.SellerRepository;
import com.assignment.seller_dashboard_backend.service.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SellerController {

    private final SellerService sellerService;
    private final SellerRepository sellerRepository;

    public SellerController(SellerService sellerService, SellerRepository sellerRepository) {
        this.sellerService = sellerService;
        this.sellerRepository = sellerRepository;
    }

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @GetMapping("/seller/{id}/summary")
    public SellerSummaryResponse getSummary(@PathVariable Integer id) {
        return sellerService.getSellerSummary(id);
    }
}
