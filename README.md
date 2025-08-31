Digital Wallet Service (LLD)
Problem Statement
Design and implement a Digital Wallet Service that allows users to manage their digital money, make transactions, and link multiple payment methods. The system should handle currency conversions, track transactions, and manage different types of accounts.

Requirements
Account Management:

Create and manage user accounts
Support multiple payment methods (Bank Account, Credit Card)
Handle account balances and transactions
Transaction Management:

Process money transfers
Track transaction history
Handle transaction status and types
Payment Methods:

Support bank account integration
Support credit card integration
Allow adding/removing payment methods
Currency Support:

Handle multiple currencies
Provide currency conversion
Maintain exchange rates
Security and Validation:

Validate transactions
Handle insufficient funds
Ensure data consistency
Core Entities
1. DigitalWallet
Fields: String id, User user, double balance, List paymentMethods, List transactions
Methods: addMoney(), sendMoney(), getBalance(), addPaymentMethod(), removePaymentMethod()
2. User
Fields: String id, String name, String email, String phoneNumber
Methods: updateProfile(), getWallet()
3. Account
Fields: String id, User user, double balance, Currency currency
Methods: deposit(), withdraw(), getBalance()
4. PaymentMethod
Fields: String id, User user, PaymentMethodType type
Methods: validate(), processPayment()
5. BankAccount
Fields: String accountNumber, String bankName, String ifscCode
Methods: transfer(), validate()
6. CreditCard
Fields: String cardNumber, String expiryDate, String cvv
Methods: charge(), validate()
7. Transaction
Fields: String id, Account from, Account to, double amount, Currency currency, TransactionStatus status
Methods: process(), cancel(), getStatus()
8. Currency
Fields: String code, String symbol
Methods: getExchangeRate()
9. CurrencyConverter
Methods: convert(double amount, Currency from, Currency to)
