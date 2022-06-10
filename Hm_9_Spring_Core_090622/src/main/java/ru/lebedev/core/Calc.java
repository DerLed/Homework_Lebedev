package ru.lebedev.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Repayment> calcPaymentList(Loan loan){

        BigDecimal sm = loan.getAmount();
        BigDecimal ps = loan.getRate();
        Integer per = loan.getLoanPeriod();
        LocalDate d = loan.getStartDate();

        List<Repayment> pl = new ArrayList<>();

        BigDecimal monthRate = ps.divide(BigDecimal.valueOf(12*100),2, RoundingMode.HALF_UP);

        BigDecimal r = sm.multiply(monthRate);

        BigDecimal ch = BigDecimal.valueOf(1)
                                                    .subtract(  // 1 -
                              BigDecimal.valueOf(1)
                                                    .add(
                              monthRate)  // 1 + ms
                                                    .pow(
                              -per, MathContext.DECIMAL128));

        BigDecimal monthPay = r.divide(ch, 2, RoundingMode.HALF_UP);

        int i = 0;
        while (i < per){
            d = d.plusMonths(i+1);
            BigDecimal percentage = sm.multiply(monthRate).setScale(0, RoundingMode.HALF_UP);
            BigDecimal debt = monthPay.subtract(percentage).setScale(0, RoundingMode.HALF_UP);
            pl.add(new Repayment(d, percentage, debt, false));
            sm = sm.subtract(debt);
            i++;
        }
        return pl;
    }

}
