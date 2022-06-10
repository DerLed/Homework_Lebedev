package ru.lebedev.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.lebedev.core.Loan;
import ru.lebedev.repo.LoanRepo;

import java.util.List;


@Service

public class LoanService {

    @Qualifier("loanRepo")
    private final LoanRepo loanRepo;


    public LoanService(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    List<Loan> findAll(){
        return loanRepo.findAll();
    }

    public void save(Loan loan){
        loanRepo.save(loan);
    }


}
