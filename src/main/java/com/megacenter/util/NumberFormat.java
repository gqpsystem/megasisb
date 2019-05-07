package com.megacenter.util;

import java.math.BigDecimal;

public class NumberFormat {

    public static BigDecimal toBigDecimal(BigDecimal value, int decimals) {
        BigDecimal d = value.setScale(decimals, BigDecimal.ROUND_HALF_EVEN);
        return d;
    }

    public static BigDecimal toBigDecimal(int value, int decimals) {
        BigDecimal d = new BigDecimal(value).setScale(decimals, BigDecimal.ROUND_HALF_EVEN);
        return d;
    }
    public static BigDecimal toBigDecimal(String value, int decimals) {
        BigDecimal d = new BigDecimal(value).setScale(decimals, BigDecimal.ROUND_HALF_EVEN);
        return d;
    }
    public static BigDecimal toBigDecimal(Double value, int decimals) {
        BigDecimal d = new BigDecimal(value).setScale(decimals, BigDecimal.ROUND_HALF_EVEN);
        return d;
    }
    public static BigDecimal toBigDecimal(Float value, int decimals) {
        BigDecimal d = new BigDecimal(value).setScale(decimals, BigDecimal.ROUND_HALF_EVEN);
        return d;
    }
}