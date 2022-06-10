package ru.lebedev.core;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class Repayment {
    private LocalDate paymentDate;
    private BigDecimal percentage;
    private BigDecimal debt;
    private boolean isCompleted;
}
