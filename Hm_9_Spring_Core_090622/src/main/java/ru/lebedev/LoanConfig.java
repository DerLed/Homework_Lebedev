package ru.lebedev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.lebedev.core.Loan;

@Configuration
public class LoanConfig {

    @Bean
    public Loan loan(){
        return new Loan();
    }
}
