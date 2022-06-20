package ru.lebedev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "saving_account")
public class SavingAccount extends BaseAccount{

    @Column(name = "rate")
    BigDecimal rate;
}
