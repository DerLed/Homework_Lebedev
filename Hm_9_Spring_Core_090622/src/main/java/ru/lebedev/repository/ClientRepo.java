package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.core.Client;
import ru.lebedev.core.Loan;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}
