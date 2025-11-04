package com.conversor.models;

public class Currency {
    private final String baseCode;
    private final String targetCode;
    private final double conversionRate;
    private final double conversionResult;

    public Currency(CurrencyDTO currencyDTO) {
        this.baseCode = currencyDTO.baseCode();
        this.targetCode = currencyDTO.targetCode();
        this.conversionRate = currencyDTO.conversionRate();
        this.conversionResult = currencyDTO.conversionResult();
    }

    @Override
    public String toString() {
        return String.format("CONVERSÃO DE %s PARA %s, TAXA DE CONVERSÃO: %.2f, RESULTADO DA CONVERSÃO: %.2f",
                baseCode, targetCode, conversionRate, conversionResult);
    }
}
