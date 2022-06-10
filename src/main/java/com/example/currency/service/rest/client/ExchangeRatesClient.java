package com.example.currency.service.rest.client;

import com.example.currency.service.rest.model.ExchangeRatesModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${openexchangerates.url}")
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    ExchangeRatesModel getLatestRates(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ExchangeRatesModel getHistoricalRates(@PathVariable String date, @RequestParam("app_id") String appId);
}
