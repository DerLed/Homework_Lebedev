package ru.lebedev.entity;

public interface Account{
    void addMoney(Long amount);
    void pay(Long amount);
    void transfer(Account account, Long amount);

}
