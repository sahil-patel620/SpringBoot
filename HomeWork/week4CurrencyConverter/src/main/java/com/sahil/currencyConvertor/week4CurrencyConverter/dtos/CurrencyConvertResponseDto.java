package com.sahil.currencyConvertor.week4CurrencyConverter.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConvertResponseDto {
    private String fromCurrency;
    private String toCurrency;
    private double units;
    private double convertedValue;
}
