package com.example.currency.service.rest.model;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRatesModel {

    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;
}
