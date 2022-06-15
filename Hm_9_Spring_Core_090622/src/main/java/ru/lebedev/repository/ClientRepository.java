package ru.lebedev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.core.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
