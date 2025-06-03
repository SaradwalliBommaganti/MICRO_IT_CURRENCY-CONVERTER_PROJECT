package com.currencyConverter.model;

public record ConversionRequest(String fromCurrency, String toCurrency, double amount) {

}
