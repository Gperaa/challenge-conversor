package com.conversor.models;

public record CurrencyDTO(String baseCode, String targetCode, double conversionRate, double conversionResult) {
}
