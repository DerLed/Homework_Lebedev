package ru.lebedev.entity;

public class DebitAccount extends BaseAccount{
    private Long balance;

    public DebitAccount(boolean isAddable, boolean isPaying, boolean isTransferred) {
        super(isAddable, isPaying, isTransferred);
        this.balance = 0L;
    }

    @Override
    public void addMoney(Long amount) {
        if (super.isAddable) {
            this.balance += amount;
        }
    }

    @Override
    public void pay(Long amount) {
        if(super.isPaying){
            this.balance -= amount;
        }
    }

    @Override
    public void transfer(Account account, Long amount) {
        if(super.isTransferred){
            this.balance -= amount;
            account.addMoney(amount);
        }
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }
}
