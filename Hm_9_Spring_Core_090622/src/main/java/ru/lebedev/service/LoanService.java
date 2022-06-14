package ru.lebedev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.lebedev.core.Client;
import ru.lebedev.core.Loan;
import ru.lebedev.core.LoanApplication;
import ru.lebedev.core.LoanFactory;
import ru.lebedev.repository.LoanRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanFactory loanFactory;

    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    public void save(Loan loan){
        loanRepository.save(loan);
    }

    public Optional<Loan> findById(Integer id){
        return loanRepository.findById(id);
    }

    public List<Loan> findByClientId(Integer id){
        return loanRepository.findByClientId(id);
    }

    public Loan addNewLoan(LoanApplication loanApplication){
        Loan loan = loanFactory.getLoan(loanApplication);
        return loanRepository.save(loan);
    }

    public void pay(Integer loanId, BigDecimal amount){
        loanRepository.pay(loanId, amount);
    }

}
