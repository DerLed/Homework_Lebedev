package ru.lebedev.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.lebedev.core.entity.Client;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class LoanApplication {
    private Client client;
    private BigDecimal amount;
    private BigDecimal rate;
    private Integer loanPeriod;
}
