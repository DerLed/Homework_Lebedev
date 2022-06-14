package ru.lebedev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lebedev.core.Client;
import ru.lebedev.core.Loan;
import ru.lebedev.core.LoanApplication;
import ru.lebedev.service.ClientService;
import ru.lebedev.service.LoanService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application_Hm9 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.lebedev");

        LoanService loanService = context.getBean(LoanService.class);
        ClientService clientService = context.getBean(ClientService.class);

        Client client = new Client();
        client.setName("Вася");
        clientService.save(client);

        LoanApplication la = clientService.makeLoanApplication(client.getId(),
                BigDecimal.valueOf(100000),
                BigDecimal.valueOf(10),
                12);
        loanService.addNewLoan(la);




    }
}