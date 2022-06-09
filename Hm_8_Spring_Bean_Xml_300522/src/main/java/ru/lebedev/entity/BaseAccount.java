package ru.lebedev.entity;

/**
 * Класс описывает общий аккаунт
 * переменные isAddable, isPaying, isTransferred задают возможность добавлять, платить или переводить со счета деньги
 */
public abstract class BaseAccount implements Account{

    boolean isAddable;
    boolean isPaying;
    boolean isTransferred;

    public BaseAccount(boolean isAddable, boolean isPaying, boolean isTransferred) {
        this.isAddable = isAddable;
        this.isPaying = isPaying;
        this.isTransferred = isTransferred;
    }
}
