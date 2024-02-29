package com.exchangeapi.exchangeapi.services;

import com.exchangeapi.exchangeapi.models.currencies.Currency;
import com.exchangeapi.exchangeapi.models.ResponseModel;
import com.exchangeapi.exchangeapi.dto.CurrencySearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrencyServices {

    private final ApiRequestService<Currency> apiRequestService;

    @Autowired
    public CurrencyServices(ApiRequestService<Currency> apiRequestService) {
        this.apiRequestService = apiRequestService;
    }

    public ResponseModel<Currency> currencyNews(CurrencySearchDto searchDto) {
        try {
            ResponseModel<Currency> response = apiRequestService.httpGet(
                    searchDto.getBaseURL(),
                    searchDto.getFromSymbol().name(),
                    searchDto.getToSymbol().name(),
                    searchDto.getPeriod().getValue(),
                    searchDto.getLanguage()
            );

            return response != null ? response : new ResponseModel<>();
        } catch (Exception e) {
            log.error("An error occurred:", e);
            return null;
        }
    }
}