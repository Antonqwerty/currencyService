package com.example.currency.service.rest.service;

import com.example.currency.service.rest.client.GifClient;
import com.example.currency.service.rest.model.GifModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    @Value("${giphy.api.key}")
    private String apiKey;

    @Override
    public GifModel.Root getGif(String tag) {
        return gifClient.getGif(apiKey, tag);
    }
}
