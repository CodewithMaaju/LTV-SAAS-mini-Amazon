# 🛍️ Seller Dashboard – Full Stack Application

**Backend:** Spring Boot (H2 Database)
**Frontend:** Vue.js (Vite)

This project provides a complete seller performance dashboard with backend APIs and a simple frontend UI for monitoring sales, revenue, and alerts.

---

## ✅ 1. Project Structure

```text
seller-dashboard/
│
├── seller-dashboard-backend/     # Spring Boot API
│   ├── src/
│   ├── pom.xml
│   └── README.md (optional)
│
└── seller-dashboard-frontend/    # Vue.js Frontend
    ├── src/
    ├── package.json
    └── README.md (optional)
```

---

## ✅ 2. Requirements

| Software | Version            |
| -------- | ------------------ |
| Java     | 17+                |
| Node.js  | 18+                |
| Maven    | (Wrapper included) |
| npm      | latest             |

---

## ✅ 3. Backend Setup (Spring Boot)

### 📌 Navigate to backend folder

```bash
cd seller-dashboard-backend
```

### 📌 Start Backend Server

Use Maven wrapper (no need to install Maven globally):

```bash
./mvnw spring-boot:run
```

✅ Server will start at:
**[http://localhost:8080](http://localhost:8080)**

---

## ✅ 4. Backend API Endpoints

| Endpoint                       | Description                    |
| ------------------------------ | ------------------------------ |
| `GET /api/sellers`             | Get all sellers                |
| `GET /api/seller/{id}/summary` | Get seller summary with alerts |

---

### ✅ Sample Response – `/api/sellers`

```json
[
  { "id": 1, "name": "Ali", "region": "Karachi" },
  { "id": 2, "name": "Hassan", "region": "Lahore" }
]
```

---

### ✅ Sample Response – `/api/seller/1/summary`

```json
{
  "sellerId": 1,
  "totalSales": 14500.00,
  "quantitySold": 30,
  "returnRate": 0.33,
  "alerts": [
    "Low sales alert",
    "High return rate alert"
  ]
}
```

---

## ✅ 5. Backend Project Structure

```text
src/main/java/com/assignment/seller_dashboard_backend/
│
├── controller/           # API Controllers
├── model/                # Entities + DTOs
├── repository/           # JPA Interfaces
└── service/              # Business Logic
│
src/main/resources/
├── application.properties
├── schema.sql
└── data.sql
```

---

## ✅ 6. Backend Database (H2 In-Memory)

The backend uses an **H2 in-memory database**, automatically loaded at runtime with schema and data.

### ✅ H2 Console

Access the console at:
**[http://localhost:8080/h2-console](http://localhost:8080/h2-console)**

### ✅ H2 Credentials

| Setting  | Value                  |
| -------- | ---------------------- |
| JDBC URL | `jdbc:h2:mem:sellerdb` |
| Username | `sa`                   |
| Password | *(empty)*              |

---

## ✅ 7. Caching Overview

Spring Cache is used for 30-second caching of seller summaries.

```java
@Cacheable("sellerSummaryCache")
public SellerSummaryResponse getSellerSummary(Integer sellerId) { ... }
```

✅ Improves performance
✅ Reduces database queries

---

## ✅ 8. Frontend Setup (Vue.js + Vite)

### 📌 Navigate to frontend folder

```bash
cd seller-dashboard-frontend
```

### 📌 Install dependencies

```bash
npm install
```

### 📌 Start frontend

```bash
npm run dev
```

✅ Frontend runs at:
**[http://localhost:5173](http://localhost:5173)**

---

## ✅ 9. Frontend Project Structure

```text
seller-dashboard-frontend/
│
├── src/
│   ├── components/
│   │   ├── SellerDropdown.vue
│   │   └── SellerSummary.vue
│   ├── services/
│   │   └── api.js
│   ├── App.vue
│   └── main.js
│
├── package.json
└── vite.config.js
```

---

## ✅ 10. API Base URL (Frontend)

Set the base API URL for backend communication:

```javascript
// src/services/api.js
export const API_BASE = "http://localhost:8080/api";
```

---

## ✅ 11. Frontend Example Component

### SellerDropdown.vue

```vue
<script>
import { API_BASE } from "../services/api";

export default {
  data() {
    return {
      sellers: [],
      selectedId: "",
      error: ""
    };
  },
  async mounted() {
    try {
      const res = await fetch(`${API_BASE}/sellers`);
      this.sellers = await res.json();
    } catch (err) {
      this.error = "Failed to load sellers.";
    }
  },
  emits: ["select"],
};
</script>

<template>
  <div>
    <h2>Seller Dashboard</h2>

    <select v-model="selectedId" @change="$emit('select', selectedId)">
      <option value="" disabled>Select Seller</option>
      <option v-for="s in sellers" :key="s.id" :value="s.id">
        {{ s.name }} ({{ s.region }})
      </option>
    </select>

    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>
```

---

## ✅ 12. Running the Full System

### 1️⃣ Start Backend

```bash
cd seller-dashboard-backend
./mvnw spring-boot:run
```

✅ Runs at → [http://localhost:8080](http://localhost:8080)

---

### 2️⃣ Start Frontend

```bash
cd seller-dashboard-frontend
npm install
npm run dev
```

✅ Open → [http://localhost:5173](http://localhost:5173)

---

## ✅ 13. Troubleshooting

### ❌ Backend not starting?

✔ Check Java version
✔ Run:

```bash
./mvnw clean install
```

---

### ❌ Frontend cannot load sellers?

✔ Ensure backend is running
✔ Ensure CORS is enabled
✔ Check `API_BASE` in `/src/services/api.js`

---

### ❌ H2 console not opening?

Use JDBC URL:

```
jdbc:h2:mem:sellerdb
```

---

## ✅ 14. Technologies Used

### 🔹 Backend

* Spring Boot 3.x
* Spring Data JPA / Hibernate
* Spring Cache
* H2 Database
* Java 17

### 🔹 Frontend

* Vue.js 3 (Vite)
* JavaScript (ES6)
* Fetch API
* CSS (Tailwind optional)

---

## ✅ 15. Author

Developed by **Muaz Khan**

---

## ✅ 16. License

Open-source — free to use, modify, and share.
