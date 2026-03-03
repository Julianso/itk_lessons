package com.itk.lesson._6.bank_account;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public synchronized void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount) {
        if(this.balance.compareTo(amount) > 0) {
            this.balance = this.balance.subtract(amount);
            int i = 0;
        } else {
            throw new IllegalArgumentException("Insufficient funds in the account");
        }
    }

    public synchronized BigDecimal getBalance() {
        return this.balance;
    }

}
