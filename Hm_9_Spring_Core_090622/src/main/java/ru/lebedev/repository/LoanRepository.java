package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lebedev.core.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    public Loan findByClientId(Integer id);
}