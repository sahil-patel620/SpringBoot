package com.sahil.currencyConvertor.week4CurrencyConverter.controllers;

import com.sahil.currencyConvertor.week4CurrencyConverter.clients.CurrencyClient;
import com.sahil.currencyConvertor.week4CurrencyConverter.dtos.CurrencyConvertResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CurrencyController {

    private final CurrencyClient currencyClient;


    @GetMapping(path = "/convertCurrency" )
    public CurrencyConvertResponseDto convertCurrency(@RequestParam String fromCurrency,
                                                      @RequestParam String toCurrency,
                                                       @RequestParam double units){
        double rate = currencyClient.getConversionRate(fromCurrency, toCurrency);
        double amount = rate * units;

//        CurrencyConvertResponseDto response = new CurrencyConvertResponseDto();
//        response.setFromCurrency(fromCurrency);
//        response.setToCurrency(toCurrency);
//        response.setUnits(units);
//        response.setConvertedValue(amount);

        CurrencyConvertResponseDto response = CurrencyConvertResponseDto.builder()
                .fromCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .units(units)
                .convertedValue(amount)
                .build();

        return response;
    }
}
