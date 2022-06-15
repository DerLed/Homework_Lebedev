package ru.lebedev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lebedev.core.entity.Client;
import ru.lebedev.core.entity.Loan;
import ru.lebedev.core.LoanApplication;
import ru.lebedev.core.entity.Repayment;
import ru.lebedev.repository.ClientRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findOne(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client replaceClient(Client newClient, Integer id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return clientRepository.save(newClient);
                });
    }

    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    public LoanApplication makeLoanApplication(Integer id, BigDecimal amount, BigDecimal rate, Integer loanPeriod) {
        Client client = clientRepository.findById(id).orElseThrow();
        return new LoanApplication(client, amount, rate, loanPeriod);
    }

    public void pay(Client client, Loan loan, BigDecimal amount) {
        Repayment repayment = new Repayment();
        repayment.setAmount(amount);
        repayment.setLoan(loan);
        repayment.setRepaymentDate(LocalDate.now());
    }
}
