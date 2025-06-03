package com.currencyConverter.service.impl;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.currencyConverter.model.ConversionRequest;
import com.currencyConverter.model.ConversionResponse;
import com.currencyConverter.service.CurrencyService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

	 private final RestTemplate restTemplate = new RestTemplate();

	    @Value("${currency.api.url}")
	    private String apiUrl;

	    @Value("${currency.api.key}")
	    private String apiKey;

	    @Override
	    public ConversionResponse convertCurrency(ConversionRequest request) {
	        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
	                .queryParam("base", request.fromCurrency())
	                .queryParam("symbols", request.toCurrency())
	                .toUriString();

	        // Set API key in headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("apikey", apiKey);
	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        // Make the request
	        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

	        Map<String, Object> responseBody = response.getBody();
	        Map<String, Double> rates = (Map<String, Double>) responseBody.get("rates");
	        double rate = rates.get(request.toCurrency());
	        double convertedAmount = request.amount() * rate;

	        return new ConversionResponse(
	                request.fromCurrency(),
	                request.toCurrency(),
	                request.amount(),
	                convertedAmount
	        );
	    }
}
