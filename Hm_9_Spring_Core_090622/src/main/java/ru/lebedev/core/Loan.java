package ru.lebedev.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Loan {
    private BigDecimal amount;
    private BigDecimal rate;
    private Integer loanPeriod;
    private LocalDate startDate;
    private List<Payment> paymentSchedule;

    public Loan(BigDecimal amount, BigDecimal rate, Integer loanPeriod, LocalDate startDate) {
        this.amount = amount;
        this.rate = rate;
        this.loanPeriod = loanPeriod;
        this.startDate = startDate;
        makePaymentSchedule();
    }

    private void makePaymentSchedule(){
        BigDecimal pay = Calc.calc(this);
        paymentSchedule = new ArrayList<>();

        for(int i = 0; i < loanPeriod; i++){

            paymentSchedule.add(
                    new Payment(startDate.plusMonths(i+1), pay)
            );
        }
    }
}
