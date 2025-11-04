package com.assignment.seller_dashboard_backend.model;

import java.math.BigDecimal;
import java.util.List;

public class SellerSummaryResponse {

    private Integer sellerId;
    private BigDecimal totalSales;
    private Integer totalQuantity;
    private Double returnRate;
    private List<String> alerts;

    public SellerSummaryResponse(Integer sellerId, BigDecimal totalSales,
                                 Integer totalQuantity, Double returnRate,
                                 List<String> alerts) {
        this.sellerId = sellerId;
        this.totalSales = totalSales;
        this.totalQuantity = totalQuantity;
        this.returnRate = returnRate;
        this.alerts = alerts;
    }

    public Integer getSellerId() { return sellerId; }
    public BigDecimal getTotalSales() { return totalSales; }
    public Integer getTotalQuantity() { return totalQuantity; }
    public Double getReturnRate() { return returnRate; }
    public List<String> getAlerts() { return alerts; }
}
