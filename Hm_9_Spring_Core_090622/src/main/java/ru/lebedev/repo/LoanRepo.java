package ru.lebedev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lebedev.core.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}