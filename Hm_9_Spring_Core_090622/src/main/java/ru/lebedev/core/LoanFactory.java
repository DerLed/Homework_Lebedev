package ru.lebedev.core;

import org.springframework.stereotype.Component;
import ru.lebedev.core.entity.Loan;

import java.time.LocalDate;

@Component
public class LoanFactory {
    public Loan getLoan(LoanApplication la) {
        Loan loan = new Loan();
        loan.setAmount(la.getAmount());
        loan.setRate(la.getRate());
        loan.setLoanPeriod(la.getLoanPeriod());
        loan.setMonthRepayment(LoanCalcHelper.calcAnnuityPayment(la.getAmount(), la.getRate(), la.getLoanPeriod()));
        loan.setClient(la.getClient());
        loan.setStartDate(LocalDate.now());
        return loan;
    }
}
