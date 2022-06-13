package com.example.currency.service.rest.service;

import com.example.currency.service.rest.model.GifModel;

public interface GifService {
    GifModel.Root getGif(String tag);
}
