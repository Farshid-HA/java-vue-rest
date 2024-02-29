<template>
  <Bar
    v-if="loading"
    :data="chartData"
    :options="{ maintainAspectRatio: true }"
  />
</template>

<script setup lang="ts">
import { Bar } from "vue-chartjs";
import { onMounted, ref } from "vue";
import { CurrencyTimeSeries } from "@/dtos/CurrencyTimeSeries";
import { Response } from "@/models/Response";
import { API_BASE_URL } from "@/utils/config";

import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from "chart.js";
import { Currency } from "@/models/Currency";
import { TimeSeries } from "@/models/TimeSeries";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

let chartData: any;
const loading = ref(false);
onMounted(async () => {
  try {
    const model: CurrencyTimeSeries = {
      fromSymbol: "USD",
      toSymbol: "EUR",
      period: "ONE_MONTH",
      language: "en",
    };
    console.log(API_BASE_URL);
    const response = await fetch(`${API_BASE_URL}/Finance/currencyTimeSeries`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(model),
    });

    const responseData: Response = await response.json();

    if (responseData.data) {
      chartData = updateChart(responseData.data);
      loading.value = true;
    } else {
      console.error("Invalid response data:", responseData);
    }
  } catch (error) {
    console.error("Error fetching data:", error);
  }
});

function updateChart(currencyData: Currency) {
  const labels: string[] = Object.keys(currencyData.time_series).map(
    (timestamp: string) => {
      const ts: TimeSeries | undefined = currencyData.time_series[timestamp];
      if (ts) {
        const formattedDate = new Intl.DateTimeFormat("en-US", {
          month: "2-digit",
          day: "2-digit",
        }).format(new Date(timestamp));
        return formattedDate;
      } else {
        return "";
      }
    }
  );
  const dataValues: number[] = Object.values(currencyData.time_series).map(
    (ts: TimeSeries | undefined) => ts?.change || 0
  );

  const dataset = {
    label: `Currency exchange (${currencyData.from_symbol} to ${currencyData.to_symbol})`,
    data: dataValues,
    backgroundColor: [
      "rgba(255, 99, 132, 0.2)",
      "rgba(255, 159, 64, 0.2)",
      "rgba(255, 205, 86, 0.2)",
      "rgba(75, 192, 192, 0.2)",
      "rgba(54, 162, 235, 0.2)",
      "rgba(153, 102, 255, 0.2)",
      "rgba(201, 203, 207, 0.2)",
    ],
    borderColor: [
      "rgb(255, 99, 132)",
      "rgb(255, 159, 64)",
      "rgb(255, 205, 86)",
      "rgb(75, 192, 192)",
      "rgb(54, 162, 235)",
      "rgb(153, 102, 255)",
      "rgb(201, 203, 207)",
    ],
    borderWidth: 1,
  };
  return {
    labels,
    datasets: [dataset],
  };
}
</script>

<style scoped></style>
