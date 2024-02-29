package com.exchangeapi.exchangeapi.controller;

import com.exchangeapi.exchangeapi.dto.CurrencySearchDto;
import com.exchangeapi.exchangeapi.services.CurrencyServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Finance")
@RequiredArgsConstructor
public class FinanceController {

    private final CurrencyServices currencyServices;


    @PostMapping("/currencyTimeSeries")
    public ResponseEntity<?> currencyTimeSeries(@RequestBody CurrencySearchDto searchDto) {
        return ResponseEntity.ok(currencyServices.currencyNews(searchDto));
    }
}
