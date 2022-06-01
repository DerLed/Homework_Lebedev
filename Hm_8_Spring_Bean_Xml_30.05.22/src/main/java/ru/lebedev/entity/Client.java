package ru.lebedev.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Account> accountList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void sayAllAmountMoney(){
        System.out.println("Привет, я " + name + ", вот мои финансы:");
        Long debitMoney = accountList.stream()
                .filter(a -> a.getClass().equals(DebitAccount.class))
                .mapToLong(a-> ((DebitAccount) a).getBalance())
                .sum();
        Long creditMoney = accountList.stream()
                .filter(a -> a.getClass().equals(CreditAccount.class))
                .mapToLong(a-> ((CreditAccount) a).getLoanAmount())
                .sum();
        System.out.println("Мои доступные средства: " + debitMoney);
        System.out.println("Мои кредитные средства: " + creditMoney);
        System.out.println("Мой общий баланс: " + (debitMoney - creditMoney));
    }

    public void payWidthDebitAccount(Long amount){
        Account paymentAccount = accountList.stream()
                .filter(account -> account.getClass().equals(DebitAccount.class))
                .findFirst().orElseThrow();
        paymentAccount.pay(amount);
    }

    public void transferFromDebitAccount(Account account, Long amount){
        Account paymentAccount = accountList.stream()
                .filter(a -> a.getClass().equals(DebitAccount.class))
                .findFirst().orElseThrow();
        paymentAccount.transfer(account, amount);
    }

    public Account getCreditAccount(){
        return accountList.stream()
                .filter(a -> a.getClass().equals(CreditAccount.class))
                .findFirst().orElseThrow();
    }

    public Account getDebitAccount(){
        return accountList.stream()
                .filter(a -> a.getClass().equals(DebitAccount.class))
                .findFirst().orElseThrow();
    }

}
