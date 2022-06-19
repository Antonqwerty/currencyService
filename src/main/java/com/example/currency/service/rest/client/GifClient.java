package com.example.currency.service.rest.client;

import com.example.currency.service.rest.model.GifModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif",url = "${giphy.url}")
public interface GifClient {

    @GetMapping
    GifModel.Root getGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}
