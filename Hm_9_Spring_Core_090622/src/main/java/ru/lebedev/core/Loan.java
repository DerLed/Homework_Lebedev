package ru.lebedev.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Loan {
    private BigDecimal amount;
    private BigDecimal rate;
    private Integer loanPeriod;

}
