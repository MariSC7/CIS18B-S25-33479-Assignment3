// Decorator Pattern - Define SecureBankAccount Class
abstract class BankAccountDecorator extends BankAccount {
    protected BankAccount decoratedAccount;

    public BankAccountDecorator(BankAccount account) {
        super(account.accountNumber, account.getBalance());
        this.decoratedAccount = account;
    }
}

// Todo: Implement SecureBankAccount (Concrete Decorator)
class SecureBankAccount extends BankAccountDecorator {
    public SecureBankAccount(BankAccount account) {
        super(account);
    }
    // Prevents withdrawing of more than $500
    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > 500) {
            throw new InvalidAccountOperationException("Withdrawal limit exceeded. You may widthdraw up to $500."); 
        }
        decoratedAccount.withdraw(amount);
    }
}