package ru.lebedev.entity;

public class CreditAccount extends BaseAccount{
    private Long loanAmountLimit;
    private Long loanAmount;


    public CreditAccount(boolean isAddable, boolean isPaying, boolean isTransferred, Long loanAmountLimit) {
        super(isAddable, isPaying, isTransferred);
        this.loanAmountLimit = loanAmountLimit;
        this.loanAmount = loanAmountLimit;
    }

    @Override
    public void addMoney(Long amount) {
        if (super.isAddable) {
            this.loanAmount -= amount;
        }
    }

    @Override
    public void pay(Long amount) {
        if(super.isPaying){
            if (this.loanAmount + amount <= loanAmountLimit)
                this.loanAmount += amount;
        }
    }

    @Override
    public void transfer(Account account, Long amount) {
        if(super.isTransferred){
            if (this.loanAmount + amount <= loanAmountLimit){
                this.loanAmount += amount;
                account.addMoney(amount);
            }
        }
    }

    public void setLoanAmountLimit(Long loanAmountLimit) {
        this.loanAmountLimit = loanAmountLimit;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }
}
