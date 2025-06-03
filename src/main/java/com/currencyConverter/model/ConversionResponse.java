package com.currencyConverter.model;

public record ConversionResponse(String fromCurrency, String toCurrency, double originalAmount, double convertedAmount) {

}
