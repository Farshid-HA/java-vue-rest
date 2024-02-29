package com.exchangeapi.exchangeapi.models.currencies;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Currency {
    private String fromSymbol;
    private String toSymbol;
    private String type;
    private double exchangeRate;
    private double previousClose;
    private String lastUpdateUtc;
    private Map<String, TimeSeries> timeSeries;
    private int utcOffsetSec;
    private int intervalSec;
    private String period;

}
