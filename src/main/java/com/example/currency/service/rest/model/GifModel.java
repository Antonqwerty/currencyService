package com.example.currency.service.rest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class GifModel {

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        public String type;
        public String id;
        public String url;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Root{
        public Data data;
    }


}
