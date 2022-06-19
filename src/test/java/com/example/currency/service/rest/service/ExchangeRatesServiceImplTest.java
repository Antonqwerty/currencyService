package com.example.currency.service.rest.service;

import com.example.currency.service.rest.client.ExchangeRatesClient;
import com.example.currency.service.rest.model.ExchangeRatesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExchangeRatesServiceImplTest {

    private final static String CURRENCY = "RUB";
    private final static double RATE1 = 1.0;
    private final static double RATE2 = 2.0;


    @Mock
    private ExchangeRatesClient exchangeRatesClient;


    @InjectMocks
    private ExchangeRatesServiceImpl exchangeRatesService;

    @BeforeEach
    void initialize() {
        ReflectionTestUtils.setField(exchangeRatesService,"appId","0");
    }

    @Test
    void rateIncrease() {

        ExchangeRatesModel actualRate = new ExchangeRatesModel();
        actualRate.setRates(Map.of(CURRENCY, RATE2));
        Mockito.when(exchangeRatesClient.getLatestRates(Mockito.anyString())).thenReturn(actualRate);

        ExchangeRatesModel historicalRate = new ExchangeRatesModel();
        historicalRate.setRates(Map.of(CURRENCY, RATE1));
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Mockito.when(exchangeRatesClient.getHistoricalRates(Mockito.eq(yesterday), Mockito.anyString())).thenReturn(historicalRate);

        Boolean result = exchangeRatesService.isRateIncrease(CURRENCY);
        assertTrue(result);

    }

    @Test
    void rateDecrease() {

        ExchangeRatesModel actualRate = new ExchangeRatesModel();
        actualRate.setRates(Map.of(CURRENCY, RATE1));
        Mockito.when(exchangeRatesClient.getLatestRates(Mockito.anyString())).thenReturn(actualRate);

        ExchangeRatesModel historicalRate = new ExchangeRatesModel();
        historicalRate.setRates(Map.of(CURRENCY, RATE2));
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Mockito.when(exchangeRatesClient.getHistoricalRates(Mockito.eq(yesterday), Mockito.anyString())).thenReturn(historicalRate);

        Boolean result = exchangeRatesService.isRateIncrease(CURRENCY);
        assertFalse(result);

    }
}