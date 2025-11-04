package com.assignment.seller_dashboard_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    private Integer id;
    private String name;
    private String region;

    public Seller() {}

    public Seller(Integer id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getRegion() { return region; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRegion(String region) { this.region = region; }
}
