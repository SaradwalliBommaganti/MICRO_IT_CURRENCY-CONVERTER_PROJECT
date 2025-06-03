package com.currencyConverter.service;

import com.currencyConverter.model.ConversionRequest;
import com.currencyConverter.model.ConversionResponse;

public interface CurrencyService {
    ConversionResponse convertCurrency(ConversionRequest request);

}
