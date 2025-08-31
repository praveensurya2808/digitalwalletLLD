package org.Learning.digitalwalletservice;

import org.Learning.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private  final String id ;
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final BigDecimal amount;
    private final org.Learning.Currency currency;
    private final LocalDateTime timestamp;


    public Transaction(String id, Currency currency, Account sourceAccount, Account destinationAccount, BigDecimal amount) {
        this.currency = currency;
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();

    }

    public String getId() {
        return id;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
