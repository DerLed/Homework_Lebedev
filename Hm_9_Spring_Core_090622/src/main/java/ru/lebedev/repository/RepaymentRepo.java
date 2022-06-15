package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.core.entity.Repayment;

public interface RepaymentRepo extends JpaRepository<Repayment, Integer> {
}
