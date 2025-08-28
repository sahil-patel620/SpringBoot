package com.sahil.currencyConvertor.week4CurrencyConverter.clients;

import com.sahil.currencyConvertor.week4CurrencyConverter.dtos.CurrencyConvertResponseDto;

public interface CurrencyClient {
    double getConversionRate(String fromCurrency, String toCurrency);
}
