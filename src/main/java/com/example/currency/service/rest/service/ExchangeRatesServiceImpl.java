package com.example.currency.service.rest.service;

import com.example.currency.service.rest.client.ExchangeRatesClient;
import com.example.currency.service.rest.model.ExchangeRatesModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesClient exchangeRatesClient;

    @Value("${openexchangerates.app.id}")
    private String appId;

    public boolean isRateIncrease(String currency) {
        ExchangeRatesModel exchangeLatestRate = exchangeRatesClient.getLatestRates(appId);
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ExchangeRatesModel historicalRate = exchangeRatesClient.getHistoricalRates(yesterday, appId);
        double exchangeRate = exchangeLatestRate.getRates().get(currency);
        double historical = historicalRate.getRates().get(currency);
        return exchangeRate > historical;
    }

}

