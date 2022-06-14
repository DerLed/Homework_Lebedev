package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lebedev.core.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer>, CustomLoanRepository{
    public List<Loan> findByClientId(Integer id);

    @Query("select l from Loan l where l.id = :id")
    public Loan f(@Param("id") Integer id);
}