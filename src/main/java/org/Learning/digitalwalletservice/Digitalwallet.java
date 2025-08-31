package org.Learning.digitalwalletservice;

import org.Learning.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Digitalwallet {
    private static Digitalwallet instance;
    private final Map<String, User> users;
    private final Map<String, Account> accounts;
    private final Map<String, PaymentMethod> paymentMethods;

    private Digitalwallet() {
        this.users = new ConcurrentHashMap<>();
        this.accounts = new ConcurrentHashMap<>();
        this.paymentMethods = new ConcurrentHashMap<>();
    }

    public static synchronized  Digitalwallet getInstance() {
        if (instance == null) {
            instance = new Digitalwallet();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addpaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId) {
        return paymentMethods.get(paymentMethodId);
    }

    public synchronized  void fundtransfer(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency) {

        if (sourceAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(currency, sourceAccount.getCurrency(), amount);
        }

        if(destinationAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(currency, destinationAccount.getCurrency(), amount);
        }
        destinationAccount.deposit(amount);

        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, destinationAccount.getCurrency(),sourceAccount, destinationAccount, amount);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    public List<Transaction> getTransactions(Account account) {
        return account.getTransactions();
    }


    private String generateTransactionId() {
        return java.util.UUID.randomUUID().toString();
    }



}
