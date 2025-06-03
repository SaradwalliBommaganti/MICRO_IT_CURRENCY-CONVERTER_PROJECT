package com.currencyConverter.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currencyConverter.model.ConversionRequest;
import com.currencyConverter.model.ConversionResponse;
import com.currencyConverter.service.CurrencyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/currency")
@AllArgsConstructor
public class CurrencyController {
	
	
    
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        return currencyService.convertCurrency(request);
    }
}
