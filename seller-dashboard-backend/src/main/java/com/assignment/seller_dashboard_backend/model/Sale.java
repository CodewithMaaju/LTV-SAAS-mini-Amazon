package com.assignment.seller_dashboard_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private LocalDate date;
    private Integer quantity;
    private BigDecimal price;
    private Boolean returned;

    public Sale() {}

    public Integer getId() { return id; }
    public Seller getSeller() { return seller; }
    public LocalDate getDate() { return date; }
    public Integer getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }
    public Boolean getReturned() { return returned; }

    public void setId(Integer id) { this.id = id; }
    public void setSeller(Seller seller) { this.seller = seller; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setReturned(Boolean returned) { this.returned = returned; }
}
