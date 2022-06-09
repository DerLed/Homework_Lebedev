package ru.lebedev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lebedev.core.Calc;
import ru.lebedev.core.Loan;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Application_Hm9 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.lebedev");

//        System.out.println(Calc.calc(new Loan(
//                                            BigDecimal.valueOf(100000),
//                                            BigDecimal.valueOf(15),
//                                            12)
//                                    )
//        );

//        System.out.println(BigDecimal.valueOf(4).pow(-2, MathContext.DECIMAL128));

        Loan loan = new Loan(BigDecimal.valueOf(100000), BigDecimal.valueOf(15),12, LocalDate.now());
        loan.getPaymentSchedule().forEach(System.out::println);
    }
}