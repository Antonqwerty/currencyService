package com.example.currency.service.rest.service;

import com.example.currency.service.rest.client.GifClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    @Value("${giphy.api.key}")
    private String apiKey;

    @Override
    public Map<String, Object> getGif(String tag) {
        return gifClient.getGif(apiKey, tag);
    }
}
