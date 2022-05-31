package ru.lebedev.entity;

public class PaymentAccount extends Account implements Payable, Replenishable, Transferable{

    @Override
    public void pay(Long amount) {

    }

    @Override
    public void addMoney(Long amount) {

    }

    @Override
    public void transfer(Account account, Long amount) {

    }
}
