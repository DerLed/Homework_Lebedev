package ru.lebedev.entity;

public interface Transferable {
    void transfer(Account account, Long amount);
}
