package com.example.currency.service.rest.controller;

import com.example.currency.service.rest.service.ExchangeRatesService;
import com.example.currency.service.rest.service.GifService;
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

    @Value("${giphy.rich}")
    private String richTag;
    @Value("${giphy.broke}")
    private String brokeTag;

    private final ExchangeRatesService exchangeRatesService;
    private final GifService gifService;

    @GetMapping("/getGif/{currency}")
    public String getGif(@PathVariable String currency) {
        if (exchangeRatesService.isRateIncrease(currency)) {
            return gifService.getGif(richTag).data.url;
        } else {
            return gifService.getGif(brokeTag).data.url;
        }
    }
}
