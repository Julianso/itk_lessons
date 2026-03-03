package com.itk.lesson._6.bank_account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> accountList = new ArrayList<>();

    public synchronized BankAccount createAccount(int balance) {
        return this.createAccount(new BigDecimal(balance));
    }

    public synchronized BankAccount createAccount(BigDecimal balance) {
        BankAccount account = new BankAccount(balance);
        accountList.add(account);
        return account;
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        this.transfer(fromAccount, toAccount, new BigDecimal(amount));
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount) > 0) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                } else {
                    throw new IllegalArgumentException("Insufficient funds in source account");
                }
            }
        }
    }

    public BigDecimal getTotalBalance() {

        BigDecimal result = new BigDecimal(0);

        for(BankAccount account : this.accountList) {
            result = result.add(account.getBalance());
        }

        return result;
    }

}
