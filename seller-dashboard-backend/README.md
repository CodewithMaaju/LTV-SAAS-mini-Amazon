
# Seller Dashboard – Backend (Spring Boot API)

A lightweight backend service built using **Spring Boot**, **Spring Data JPA**, **H2 In-Memory Database**, and **Spring Cache**.  
This service provides REST APIs for fetching sellers and calculating seller performance summaries.

---

## ✅ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Spring Cache (Simple In-Memory)
- Maven

---

## ✅ Project Structure

```
seller-dashboard-backend/
├── src/main/java/com/assignment/seller_dashboard_backend/
│   ├── controller/
│   ├── service/
│   ├── model/
│   ├── repository/
│   └── SellerDashboardBackendApplication.java
│
└── src/main/resources/
    ├── application.properties
    ├── schema.sql
    └── data.sql
```

---

## ✅ Setup Instructions

### 1. Requirements
- Java **17+**
- Maven **3.6+**
- Any IDE: VS Code, IntelliJ, Eclipse

---

### 2. Run Backend

Open terminal:

```
cd seller-dashboard-backend
mvn clean install
.\mvnw.cmd spring-boot:run
```

Server starts at:

👉 **http://localhost:8080**

---

## ✅ API Endpoints

### ✅ Get All Sellers
```
GET /api/sellers
```

**Example Response**
```json
[
  { "id": 1, "name": "Ali", "region": "Karachi" },
  { "id": 2, "name": "Hassan", "region": "Lahore" }
]
```

---

### ✅ Get Seller Summary
```
GET /api/seller/{id}/summary
```

**Example Request**
```
GET http://localhost:8080/api/seller/1/summary
```

**Example Response**
```json
{
  "sellerId": 1,
  "totalSales": 14500.0,
  "quantitySold": 30,
  "returnRate": 0.33,
  "alerts": ["Low sales alert", "High return rate alert"]
}
```

---

## ✅ Database Setup (H2)

H2 console available at:

👉 **http://localhost:8080/h2-console**

**Configuration:**

| Key | Value |
|------|--------|
| JDBC URL | `jdbc:h2:mem:sellerdb` |
| Username | `sa` |
| Password | *(empty)* |

---

## ✅ Caching

Caching is implemented using:

```java
@Cacheable("sellerSummaryCache")
public SellerSummaryResponse getSellerSummary(Integer sellerId)
```

✅ Faster repeated calls  
✅ Lower DB load  
✅ Clears on restart  

---

## ✅ Seed Data

`schema.sql` initializes tables.  
`data.sql` inserts:

### Sellers
- Ali — Karachi  
- Hassan — Lahore

### Sales
Each sale contains:
- quantity  
- price  
- returned flag  

---

## ✅ Error Handling

### ❌ Seller Not Found
```json
{
  "error": "Seller not found"
}
```

### ❌ Internal Server Error
```json
{
  "error": "Internal Server Error"
}
```

---

## ✅ How to Extend
- Add new sellers → edit `data.sql`
- Add new KPIs → modify `SellerService`
- Add API routes → modify `SellerController`

---

## ✅ License
Free to use for assessments & production.

