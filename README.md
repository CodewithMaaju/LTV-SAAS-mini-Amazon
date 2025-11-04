Seller Dashboard – Full Stack Project

Backend: Spring Boot (H2 DB)
Frontend: Vue.js (Vite)

✅ Project Structure
seller-dashboard-backend/
seller-dashboard-frontend/

✅ 1. Backend Setup (Spring Boot)
▶ Requirements

Java 17

Maven

IDE (IntelliJ / VS Code / Eclipse)

▶ Start the Backend

Open terminal in:

seller-dashboard-backend


Run:

 .\mvnw.cmd spring-boot:run


Backend runs at:

http://localhost:8080

▶ API Endpoints
Endpoint	Description
GET /api/sellers	Get all sellers
GET /api/seller/{id}/summary	Get seller summary by ID
✅ Example Response (GET /api/sellers)
[
  { "id": 1, "name": "Ali", "region": "Karachi" },
  { "id": 2, "name": "Hassan", "region": "Lahore" }
]

✅ 2. Frontend Setup (Vue.js + Vite)
▶ Requirements

Node.js (18+)

▶ Create Project (Already Done)

If not created:

npm create vue@latest seller-dashboard-frontend


Choose:
✅ JavaScript
✅ No (for Rolldown)

▶ Install Dependencies

Inside frontend folder:

cd seller-dashboard-frontend
npm install

▶ Run Frontend
npm run dev


Frontend runs at:

http://localhost:5173

✅ 3. Configure Backend API URL in Frontend

Inside:

src/services/api.js


Create:

export const API_BASE = "http://localhost:8080/api";

✅ 4. Example Vue Component (Seller List)

Inside:

src/components/SellerList.vue

<script>
import { API_BASE } from "../services/api.js";

export default {
  data() {
    return {
      sellers: [],
    };
  },
  async mounted() {
    const res = await fetch(`${API_BASE}/sellers`);
    this.sellers = await res.json();
  },
};
</script>

<template>
  <div>
    <h2>All Sellers</h2>
    <ul>
      <li v-for="s in sellers" :key="s.id">
        {{ s.id }} — {{ s.name }} ({{ s.region }})
      </li>
    </ul>
  </div>
</template>

<style>
h2 { color: #333; }
</style>

✅ 5. Project Commands
Backend
mvn spring-boot:run

Frontend
npm install
npm run dev

✅ 6. Folder Overview
seller-dashboard-backend/
 └── src/main/java/com/assignment/...
 └── src/main/resources/
     ├── application.properties
     ├── schema.sql
     └── data.sql

seller-dashboard-frontend/
 ├── index.html
 ├── package.json
 └── src/
     ├── main.js
     ├── App.vue
     └── components/

✅ 7. Notes

Backend uses H2 in-memory database, auto-loads schema.sql + data.sql.

Cache enabled for performance.

CORS enabled for frontend requests.