package com.example.currency.service.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "${giphy.url}")
public interface GifClient {

    @GetMapping
    Map<String, Object> getGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}
