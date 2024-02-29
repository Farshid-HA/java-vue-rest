package com.exchangeapi.exchangeapi.models.currencies;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TimeSeries {
    private double exchangeRate;
    private double change;
    private double changePercent;

}
