package ru.lebedev;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lebedev.entity.Client;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Client client = context.getBean("client", Client.class);

    }

}