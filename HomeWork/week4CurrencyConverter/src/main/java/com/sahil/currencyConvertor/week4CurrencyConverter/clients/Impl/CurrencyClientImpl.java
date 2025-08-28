package com.sahil.currencyConvertor.week4CurrencyConverter.clients.Impl;

import com.sahil.currencyConvertor.week4CurrencyConverter.clients.CurrencyClient;
import com.sahil.currencyConvertor.week4CurrencyConverter.dtos.ApiResponseDto;
import com.sahil.currencyConvertor.week4CurrencyConverter.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CurrencyClientImpl implements CurrencyClient {

    private final RestClient restClient;
    Logger log = LoggerFactory.getLogger(CurrencyClientImpl.class);

    @Value("${currencyService.api.key}")
    private  String apiKey;

    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) {
    try {
        log.error("Trying to get rate of the currency");
        ApiResponseDto response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest")
                        .queryParam("apikey", apiKey)
                        .queryParam("currencies", toCurrency)
                        .queryParam("base_currency", fromCurrency)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                    log.error(new String(res.getBody().readAllBytes()));
                    throw new ResourceNotFoundException("Could not get the rate of currency");
                })
                .body(ApiResponseDto.class);
                log.info("Successfully returned rate of currency from getConversionRate");
                return response.getData().get(toCurrency);
        }catch (Exception e){
            log.error("Exception occurred in getConversionRate" , e);
            throw new RuntimeException(e);
        }
    }
}
