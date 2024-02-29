package com.exchangeapi.exchangeapi.dto;

import com.exchangeapi.exchangeapi.enums.CurrencyCode;
import com.exchangeapi.exchangeapi.enums.PeriodCode;
import lombok.Getter;

@Getter
public class CurrencySearchDto {

    private String baseURL;
    private CurrencyCode fromSymbol;
    private CurrencyCode toSymbol;
    private PeriodCode period;
    private String language;

    public CurrencySearchDto(CurrencyCode fromSymbol, CurrencyCode toSymbol, PeriodCode period) {
        this.baseURL = "https://real-time-finance-data.p.rapidapi.com/currency-time-series?";
        this.fromSymbol = fromSymbol;
        this.toSymbol = toSymbol;
        this.period = period;
        this.language = "en";
    }
}
