package ru.lebedev.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Calc {
    public static BigDecimal calc(Loan loan){
        BigDecimal sm = loan.getAmount();
        BigDecimal ps = loan.getRate();
        Integer per = loan.getLoanPeriod();

        BigDecimal mesStavka = ps.divide(BigDecimal.valueOf(12*100));

        BigDecimal r = sm.multiply(mesStavka)
                .divide(
                        BigDecimal.valueOf(1).subtract(
                            BigDecimal.valueOf(1).add(mesStavka)
                                    .pow(per-(per *2))
                        )
                );
        return r;
    }
}
