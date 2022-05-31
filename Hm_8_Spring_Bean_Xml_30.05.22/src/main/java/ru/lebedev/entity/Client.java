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

    }
}
