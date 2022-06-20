package ru.lebedev.entity;

import java.math.BigDecimal;

@Entity
@Table(name = "saving_account")
public class SavingAccount extends BaseAccount{

    @Column(name = "rate")
    BigDecimal rate;
}
