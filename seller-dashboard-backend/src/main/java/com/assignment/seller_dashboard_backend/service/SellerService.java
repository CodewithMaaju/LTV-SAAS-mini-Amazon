package com.assignment.seller_dashboard_backend.service;

import com.assignment.seller_dashboard_backend.model.Sale;
import com.assignment.seller_dashboard_backend.model.Seller;
import com.assignment.seller_dashboard_backend.model.SellerSummaryResponse;
import com.assignment.seller_dashboard_backend.repository.SaleRepository;
import com.assignment.seller_dashboard_backend.repository.SellerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final SaleRepository saleRepository;

    public SellerService(SellerRepository sellerRepository, SaleRepository saleRepository) {
        this.sellerRepository = sellerRepository;
        this.saleRepository = saleRepository;
    }

    @Cacheable("sellerSummaryCache")
    public SellerSummaryResponse getSellerSummary(Integer sellerId) {

   
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found: " + sellerId));


        List<Sale> sales = saleRepository.findBySeller_Id(sellerId);


        int totalQty = sales.stream().mapToInt(Sale::getQuantity).sum();

        BigDecimal totalSales = sales.stream()
                .map(s -> s.getPrice().multiply(BigDecimal.valueOf(s.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        long returnedCount = sales.stream()
                .filter(s -> Boolean.TRUE.equals(s.getReturned()))
                .count();

        double returnRate = sales.isEmpty() ? 0 : (double) returnedCount / sales.size();

       
        List<String> alerts = new ArrayList<>();
        if (totalQty < 50) alerts.add("Low sales alert");
        if (returnRate > 0.15) alerts.add("High return rate alert");

        return new SellerSummaryResponse(
                seller.getId(),
                totalSales,
                totalQty,
                returnRate,
                alerts
        );
    }
}
