package ru.lebedev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lebedev.core.Client;
import ru.lebedev.core.Loan;
import ru.lebedev.core.LoanApplication;
import ru.lebedev.core.Repayment;
import ru.lebedev.repository.ClientRepo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findOne(Integer id){
        return clientRepo.findById(id).orElseThrow();
    }

    public Client save(Client client){
        return clientRepo.save(client);
    }

    public Client replaceClient(Client newClient, Integer id){
        return clientRepo.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    return clientRepo.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return clientRepo.save(newClient);
                });
    }

    public void deleteById(Integer id){
        clientRepo.deleteById(id);
    }

    public LoanApplication makeLoanApplication(Integer id, BigDecimal amount, BigDecimal rate, Integer loanPeriod){
        Client client = clientRepo.findById(id).orElseThrow();
        return new LoanApplication(client, amount, rate, loanPeriod);
    }

    public void pay(Client client, Loan loan, BigDecimal amount){
        Repayment repayment = new Repayment();
        repayment.setClient(client);
        repayment.setAmount(amount);
        repayment.setLoan(loan);
        repayment.setRepaymentDate(LocalDate.now());
    }
}
