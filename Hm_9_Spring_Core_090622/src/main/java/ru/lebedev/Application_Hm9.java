package ru.lebedev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lebedev.core.entity.Client;
import ru.lebedev.core.entity.Loan;
import ru.lebedev.core.LoanApplication;
import ru.lebedev.service.ClientService;
import ru.lebedev.service.LoanService;

import java.math.BigDecimal;

public class Application_Hm9 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.lebedev");

        LoanService loanService = context.getBean(LoanService.class);
        ClientService clientService = context.getBean(ClientService.class);

        //Создадим клиента, у которого роль депозитного счета будет выполнять поле BigDecimal cash
        Client client = context.getBean(Client.class);
        client.setName("Вася");
        client.setCash(BigDecimal.valueOf(10000));
        clientService.save(client);

        //Класс LoanApplication выполняет роль промежуточного класса для связи класса кредита Loan и
        //класса клиента, так же на него повесить логику по одобрению кредита.
        //Представим, что клиент решает взять кредит, и создает заявку на кредит, с суммой и процентами и сроком
        LoanApplication la = clientService.makeLoanApplication(client.getId(),
                BigDecimal.valueOf(100000),
                BigDecimal.valueOf(10),
                12);

        //Предположим что кредит одобрен и сохраним его в БД, для этого обработаем заявку
        Loan l = loanService.addNewLoan(la);

        //Далее клиент платит по кредиту для этого используем метод из кастомного репозитория
        //что бы списание средств со счета клиента и зачисление платежа проходило за одну транзакцию
        loanService.pay(l.getId(), l.getMonthRepayment());

    }
}