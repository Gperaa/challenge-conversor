package com.conversor.service;

import com.conversor.http.ApiClient;
import com.conversor.models.Currency;
import com.conversor.models.CurrencyDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CurrencyConverter {
    private final ApiClient client;
    private final Gson gson;

    public CurrencyConverter() {
        this.client = new ApiClient();
        this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    public Currency convert(String baseCode, String targetCode, double amount) {
        String json = client.getJson(baseCode, targetCode, amount);

        CurrencyDTO dto = gson.fromJson(json, CurrencyDTO.class);

        return new Currency(dto);
    }
}
