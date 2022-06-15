package ru.lebedev.repository;

import java.math.BigDecimal;

public interface CustomLoanRepository {
    public void pay(Integer loanId, BigDecimal amount);
}
