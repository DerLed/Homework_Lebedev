package ru.lebedev.entity;

public abstract class BaseAccount implements Account{

    boolean isAddable;
    boolean isPaying;
    boolean isTransferred;

    public BaseAccount(boolean isAddable, boolean isPaying, boolean isTransferred) {
        this.isAddable = isAddable;
        this.isPaying = isPaying;
        this.isTransferred = isTransferred;
    }

    public void setAddable(boolean addable) {
        isAddable = addable;
    }

    public void setPaying(boolean paying) {
        isPaying = paying;
    }

    public void setTransferred(boolean transferred) {
        isTransferred = transferred;
    }
}
