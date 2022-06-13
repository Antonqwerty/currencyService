package com.example.currency.service.rest.controller;

import com.example.currency.service.rest.client.GifClient;
import com.example.currency.service.rest.service.ExchangeRatesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class CurrencyController {

    @Value("${giphy.api.key}")
    private String appId;
    @Value("${giphy.rich}")
    private String richTag;
    @Value("${giphy.broke}")
    private String brokeTag;

    private final ExchangeRatesServiceImpl exchangeRatesService;
    private final GifClient gifClient;

    @GetMapping("/getGif/{currency}")
    public String getGif(@PathVariable String currency) {
        if (exchangeRatesService.isRateIncrease(currency)) {
            return gifClient.getGif(appId, richTag).data.url;
        } else {
            return gifClient.getGif(appId, brokeTag).data.url;
        }
    }
}
