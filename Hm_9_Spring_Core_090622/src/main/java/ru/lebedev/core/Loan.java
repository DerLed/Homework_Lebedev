package ru.lebedev.core;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "loan")
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
    @SequenceGenerator(name = "loan_seq",
    sequenceName = "loan_loan_id_seq",
    allocationSize = 1)
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

    @Column(name = "month_repayment")
    private BigDecimal monthRepayment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
