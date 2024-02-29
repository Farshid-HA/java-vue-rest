import { TimeSeries } from "@/models/TimeSeries";

export interface Currency {
  exchange_rate: number;
  from_symbol: string;
  interval_sec: number;
  last_update_utc: string;
  period: string;
  previous_close: number;
  time_series: { [timestamp: string]: TimeSeries };
  to_symbol: string;
  type: string;
  utc_offset_sec: number;
}
