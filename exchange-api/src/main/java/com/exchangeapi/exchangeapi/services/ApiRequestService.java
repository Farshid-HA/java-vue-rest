package com.exchangeapi.exchangeapi.services;

import com.exchangeapi.exchangeapi.models.ResponseModel;
import com.exchangeapi.exchangeapi.configuration.ApiHeaders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class ApiRequestService<T> {
    private final RestTemplate restTemplate;
    private final ApiHeaders apiHeaders;


    @Autowired
    public ApiRequestService(RestTemplate restTemplate, ApiHeaders apiHeaders) {
        this.restTemplate = restTemplate;
        this.apiHeaders = apiHeaders;
    }

    public ResponseModel<T> httpGet(String baseURL, String fromSymbol, String toSymbol, String period, String language) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", apiHeaders.getApiKey());
            headers.set("X-RapidAPI-Host", apiHeaders.getApiHost());

            ResponseEntity<ResponseModel<T>> response = restTemplate.exchange(
                    buildUrl(baseURL, fromSymbol, toSymbol, period, language),
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<>() {}
            );

            return response.getBody();
        } catch (Exception e) {
            log.error("An error occurred:", e);
            return null;
        }
    }

    private String buildUrl(String baseURL, String fromSymbol, String toSymbol, String period, String language) {
        return UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("from_symbol", fromSymbol)
                .queryParam("to_symbol", toSymbol)
                .queryParam("period", period)
                .queryParam("language", language)
                .build().toString();
    }
}