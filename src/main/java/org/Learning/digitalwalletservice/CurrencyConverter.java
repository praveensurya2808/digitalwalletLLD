package org.Learning.digitalwalletservice;

import org.Learning.Currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<Currency, BigDecimal> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put(Currency.USD, BigDecimal.ONE);
        exchangeRates.put(Currency.EUR, new BigDecimal("0.92"));
        exchangeRates.put(Currency.INR, new BigDecimal("82.80"));
        exchangeRates.put(Currency.YEN, new BigDecimal("149.75"));
        exchangeRates.put(Currency.POUND, new BigDecimal("0.81"));
    }

    public static BigDecimal convert(Currency from, Currency to, BigDecimal amount) {
        BigDecimal sourceRate = exchangeRates.get(from);
        BigDecimal targetRate = exchangeRates.get(to);
        return amount.multiply(targetRate).divide(sourceRate);
    }
}
