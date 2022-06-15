package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.lebedev.core.entity.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer>, CustomLoanRepository{
    public List<Loan> findByClientId(Integer id);

    @Query("select l from Loan l where l.id = :id")
    public Loan findByIdWidthQuery(@Param("id") Integer id);
}