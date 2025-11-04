
# Seller Dashboard – Frontend (Vue.js 3 + Vite)

A lightweight Vue.js frontend application that consumes the Spring Boot backend API and displays seller performance, sales analytics, and alerts.

---

## ✅ Tech Stack

- Vue.js 3 (Composition API / Options API)
- Vite
- JavaScript
- Basic CSS
- Fetch API

---

## ✅ Project Structure

```
seller-dashboard-frontend/
├── index.html
├── package.json
└── src/
    ├── main.js
    ├── App.vue
    ├── components/
    │   ├── SellerDropdown.vue
    │   └── SellerSummary.vue
    └── services/
        └── api.js
```

---

## ✅ Setup Instructions

### 1. Requirements
- Node.js **18+**
- npm (or yarn)

---

### 2. Install Dependencies

```
cd seller-dashboard-frontend
npm install
```

---

### 3. Run the Frontend

```
npm run dev
```

Runs at:

👉 **http://localhost:5173**

---

## ✅ API Configuration

File: **src/services/api.js**

```js
export const API_BASE = "http://localhost:8080/api";
```

---

## ✅ Main Components

### ✅ 1. SellerDropdown.vue
- Fetches **all sellers**
- Displays them in a dropdown
- Emits seller ID to parent component

### ✅ 2. SellerSummary.vue
Displays:
- Total sales  
- Quantity sold  
- Return rate  
- Alerts  

---

## ✅ Example API Response

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

## ✅ Troubleshooting

### ❌ Sellers Not Loading
- Backend must be running on **port 8080**
- Correct API URL in `api.js`
- CORS must be enabled (already enabled)

### ❌ Summary Not Updating
Check seller exists:
```
GET http://localhost:8080/api/sellers
```

---

## ✅ Build for Production

```
npm run build
```

Compiled files output into:

```
dist/
```

---

## ✅ Deployment Options

- Netlify
- Vercel
- GitHub Pages
- Firebase Hosting
- Render + Spring Boot backend

---

## ✅ License
Free to use for assessments & projects.

