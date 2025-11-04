package com.assignment.seller_dashboard_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SellerDashboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerDashboardBackendApplication.class, args);
	}

}
