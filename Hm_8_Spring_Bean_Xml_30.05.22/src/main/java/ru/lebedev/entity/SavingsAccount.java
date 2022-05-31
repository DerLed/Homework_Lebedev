package ru.lebedev.entity;

public class SavingsAccount extends Account implements Transferable{
    @Override
    public void transfer(Account account, Long amount) {
        super.balance -= amount;
        account.addMoney(amount);
    }
}
