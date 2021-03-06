package ru.lebedev.core.entity;

import lombok.*;
import ru.lebedev.core.entity.Loan;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "repayment")
public class Repayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repayment_id")
    private Integer id;
    @Column(name = "repayment_date")
    private LocalDate repaymentDate;
    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

}
