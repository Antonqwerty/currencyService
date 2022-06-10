package com.example.currency.service.rest.controller;

import com.example.currency.service.rest.service.ExchangeRatesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class CurrencyController {

    private ExchangeRatesServiceImpl exchangeRatesService;

    public List<String> getRates() {
        return exchangeRatesService.getCodes();
    }
}
