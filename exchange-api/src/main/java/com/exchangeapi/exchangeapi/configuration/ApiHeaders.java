package com.exchangeapi.exchangeapi.configuration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiHeaders {
    @Getter
    @Value("${api.key}")
    private String apiKey;

    @Getter
    @Value("${api.host}")
    private String apiHost;
}
