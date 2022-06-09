package ru.lebedev.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class Calc {
    public static BigDecimal calc(Loan loan){
        BigDecimal sm = loan.getAmount();
        BigDecimal ps = loan.getRate();
        Integer per = loan.getLoanPeriod();

        BigDecimal mesStavka = ps.divide(BigDecimal.valueOf(12*100));

        BigDecimal r = sm.multiply(mesStavka);

        BigDecimal rtt = BigDecimal.valueOf(1).subtract(  // 1 -
                BigDecimal.valueOf(1).add(mesStavka)  // 1 + ms
                        .pow(-per, MathContext.DECIMAL128));


        return r.divide(rtt, 2, RoundingMode.HALF_UP);
    }
}
