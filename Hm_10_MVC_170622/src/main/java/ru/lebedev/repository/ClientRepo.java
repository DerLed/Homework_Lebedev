package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
