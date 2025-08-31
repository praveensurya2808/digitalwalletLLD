package org.Learning.digitalwalletservice;

import org.Learning.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private BigDecimal balance;
    private final User user;
    private final String accountNumber;
    private final Currency currency;
    private final List<Transaction> transactions;

    public Account(String id, User user,String accountNumber, Currency currency ) {
        this.id = java.util.UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.user = user;
        this.currency = currency;
        this.transactions = new ArrayList<>();
    }

    public synchronized  void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
    public synchronized  void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else {
            throw new InsufficientfundException("Insufficient funds in the account.");
        }
    }

    public synchronized void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
