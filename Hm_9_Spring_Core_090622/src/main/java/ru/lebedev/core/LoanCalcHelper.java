package ru.lebedev.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class LoanCalcHelper {
    public static BigDecimal calcAnnuityPayment(BigDecimal amount, BigDecimal rate, Integer loanPeriod) {

        BigDecimal monthRate = rate.divide(BigDecimal.valueOf(12 * 100), 2, RoundingMode.HALF_UP);

        BigDecimal nm = amount.multiply(monthRate);

        BigDecimal dnm = BigDecimal.valueOf(1).subtract(  // 1 -
                BigDecimal.valueOf(1).add(monthRate)  // 1 + ms
                        .pow(-loanPeriod, MathContext.DECIMAL128));

        return nm.divide(dnm, 2, RoundingMode.HALF_UP);
    }

}
