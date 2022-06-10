package ru.lebedev.core;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loan")
public class Loan {
    @Id
    @Column(name = "loan_id")
    private Integer id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "loan_period")
    private Integer loanPeriod;
    @Column(name = "start_date")
    private LocalDate startDate;

//    private List<Repayment> repaymentSchedule;

    public Loan(BigDecimal amount, BigDecimal rate, Integer loanPeriod, LocalDate startDate) {
        this.amount = amount;
        this.rate = rate;
        this.loanPeriod = loanPeriod;
        this.startDate = startDate;
//        this.repaymentSchedule = Calc.calcPaymentList(this);
//        makePaymentSchedule();
    }

    private void makePaymentSchedule(){
//        BigDecimal pay = Calc.calc(this);
//        paymentSchedule = new ArrayList<>();
//
//        for(int i = 0; i < loanPeriod; i++){
//            paymentSchedule.add(
//                    new Payment(startDate.plusMonths(i+1), pay, false)
//            );
//        }
    }
}
