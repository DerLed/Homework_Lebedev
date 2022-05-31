package ru.lebedev.entity;

public abstract class Account implements Replenishable{
    private String title;
    protected Long balance;
    private Person owner;

    @Override
    public void addMoney(Long amount) {
        balance += amount;
    }
}
