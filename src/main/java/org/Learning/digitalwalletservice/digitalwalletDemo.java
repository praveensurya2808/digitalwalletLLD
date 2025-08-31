package org.Learning.digitalwalletservice;

import org.Learning.Currency;

import java.math.BigDecimal;
import java.util.List;

public class digitalwalletDemo {
    public static void run() {
        Digitalwallet digitalWallet = Digitalwallet.getInstance();

        // Create users
        User user1 = new User("U001", "John Doe", "john@example.com", "password123");
        User user2 = new User("U002", "Jane Smith", "jane@example.com", "password456");
        digitalWallet.addUser(user1);
        digitalWallet.addUser(user2);

        // Create accounts
        Account account1 = new Account("A001", user1, "1234567890", Currency.USD);
        Account account2 = new Account("A002", user2, "9876543210", Currency.EUR);
        digitalWallet.addAccount(account1);
        digitalWallet.addAccount(account2);

        // Add payment methods
        PaymentMethod creditCard = new CreditCard("PM001", user1, "1234567890123456", "12/25", "123");
        PaymentMethod bankAccount = new BankAccount("PM002", user2, "9876543210", "987654321");
        digitalWallet.addpaymentMethod(creditCard);
        digitalWallet.addpaymentMethod(bankAccount);

        // Deposit funds
        account1.deposit(new BigDecimal("1000.00"));
        account2.deposit(new BigDecimal("500.00"));

        // Transfer funds
        digitalWallet.fundtransfer(account1, account2, new BigDecimal("100.00"), Currency.USD);

        // Get transaction history
        List<Transaction> transactionHistory1 = digitalWallet.getTransactions(account1);
        List<Transaction> transactionHistory2 = digitalWallet.getTransactions(account2);

        // Print transaction history
        System.out.println("Transaction History for Account 1:");
        for (Transaction transaction : transactionHistory1) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount() + " " + transaction.getCurrency());
            System.out.println("Timestamp: " + transaction.getTimestamp());
            System.out.println();
        }

        System.out.println("Transaction History for Account 2:");
        for (Transaction transaction : transactionHistory2) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount() + " " + transaction.getCurrency());
            System.out.println("Timestamp: " + transaction.getTimestamp());
            System.out.println();
        }
    }
}

