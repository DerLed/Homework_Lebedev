package ru.lebedev.core;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class Payment {
    private LocalDate paymentDate;
    private BigDecimal amount;
}
