package ru.lebedev;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lebedev.entity.Client;

public class Application_hm8 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //из контекста получим два бина клиента
        Client client = context.getBean("client", Client.class);
        Client client2 = context.getBean("client2", Client.class);

        //с дебетового счета клиентов произведем оплату
        client.payWidthDebitAccount(2000L);
        client2.payWidthDebitAccount(3000L);

        //переведем с дебетового счета первого клиента на дебетовый счет второго клиента
        //и переведем с дебетового счета первого клиента на кредитный счет первого клиента
        client.transferFromDebitAccount(client2.getDebitAccount(), 3500L);
        client.transferFromDebitAccount(client.getCreditAccount(), 8000L);

        //выведем общую информацию о счетах каждого клиента
        client.sayAllAmountMoney();
        client2.sayAllAmountMoney();

        /*вывод на консоль:
        Привет, я Петр, вот мои финансы:
        Мои доступные средства: 36500
        Мои кредитные средства: 992000
        Мой общий баланс: -955500
        Привет, я Василий, вот мои финансы:
        Мои доступные средства: 50500
        Мои кредитные средства: 10000
        Мой общий баланс: 40500*/
    }

}