<template>
  <div class="home">
    <BarChart></BarChart>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import BarChart from "@/components/BarChart.vue";

export default defineComponent({
  name: "HomeView",
  components: { BarChart },
});
</script>
