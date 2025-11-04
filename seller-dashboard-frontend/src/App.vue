<template>
  <div style="width: 500px; margin: 30px auto; font-family: Arial">
    <h1>Seller Dashboard</h1>

    <label>Select Seller:</label>
    <select v-model="selectedSeller" @change="loadSummary">
      <option disabled value="">Choose...</option>
      <option v-for="s in sellers" :key="s.id" :value="s.id">
        {{ s.name }}
      </option>
    </select>

    <div v-if="loading">Loading summary...</div>

    <div v-if="summary" style="margin-top: 20px; padding: 10px; border: 1px solid #ccc;">
      <h3>Summary for Seller {{ summary.sellerId }}</h3>

      <p><strong>Total Sales:</strong> {{ summary.totalSales }}</p>
      <p><strong>Total Quantity:</strong> {{ summary.totalQuantity }}</p>
      <p><strong>Return Rate:</strong> {{ (summary.returnRate * 100).toFixed(1) }}%</p>

      <h4>Alerts:</h4>
      <ul>
        <li v-for="a in summary.alerts" :key="a">{{ a }}</li>
      </ul>
    </div>

    <div v-if="error" style="color: red; margin-top: 10px;">
      {{ error }}
    </div>
  </div>
</template>

<script>
import { API_BASE } from "./services/api";

export default {
  data() {
    return {
      sellers: [],
      selectedSeller: "",
      summary: null,
      loading: false,
      error: ""
    };
  },

  async mounted() {
    await this.loadSellers();
  },

  methods: {
    async loadSellers() {
      try {
        const res = await fetch(`${API_BASE}/sellers`);
        if (!res.ok) throw new Error("API failed");
        this.sellers = await res.json();
      } catch (err) {
        this.error = "Failed to load sellers.";
        console.error(err);
      }
    },

    async loadSummary() {
      this.summary = null;
      this.error = "";
      this.loading = true;

      try {
        const res = await fetch(`${API_BASE}/seller/${this.selectedSeller}/summary`);
        if (!res.ok) throw new Error("API failed");

        this.summary = await res.json();
      } catch (err) {
        this.error = "Failed to load summary.";
        console.error(err);
      }

      this.loading = false;
    }
  }
};
</script>

<style>
select {
  padding: 8px;
  width: 100%;
  margin-bottom: 20px;
}
</style>
