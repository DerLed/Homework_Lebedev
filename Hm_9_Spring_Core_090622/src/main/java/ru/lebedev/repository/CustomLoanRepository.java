package ru.lebedev.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.lebedev.core.Loan;

import java.math.BigDecimal;
import java.util.List;

public interface CustomLoanRepository {
    public void pay(Integer loanId, BigDecimal amount);
}
