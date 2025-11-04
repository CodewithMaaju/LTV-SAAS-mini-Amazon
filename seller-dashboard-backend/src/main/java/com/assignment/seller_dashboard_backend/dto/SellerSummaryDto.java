package com.assignment.seller_dashboard_backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class SellerSummaryDto {
    private long totalSales;
    private BigDecimal totalRevenue;
    private double returnRate;
    private List<String> alerts;

    public SellerSummaryDto(long totalSales, BigDecimal totalRevenue, double returnRate, List<String> alerts) {
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.returnRate = returnRate;
        this.alerts = alerts;
    }

    public long getTotalSales() { return totalSales; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public double getReturnRate() { return returnRate; }
    public List<String> getAlerts() { return alerts; }
}
