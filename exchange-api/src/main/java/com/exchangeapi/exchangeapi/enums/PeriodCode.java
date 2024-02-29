package com.exchangeapi.exchangeapi.enums;

public enum PeriodCode {
    ONE_DAY("1D"),
    ONE_MONTH("1M"),
    ONE_YEAR("YTD");
    private final String value;

    PeriodCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
