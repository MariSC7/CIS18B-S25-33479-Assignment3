import java.util.ArrayList;
import java.util.List;

// Each class prints its own error message.
class NegativeDepositException extends Exception {
    public NegativeDepositException(String message) {
        super(message);
    }
}

class OverdrawException extends Exception {
    public OverdrawException(String message) {
        super(message);
    }
}

class InvalidAccountOperationException extends Exception {
    public InvalidAccountOperationException(String message) {
        super(message);
    }
}

class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected boolean isActive;
    private List<Observer> observers = new ArrayList<>();

    public BankAccount(String accNum, double initialBalance) {
        this.accountNumber = accNum;
        this.balance = initialBalance;
        this.isActive = true;
    }

    // Attach observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Notify observers (Todo: Implement in methods)

    // Todo: Notify all observers of transaction events
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message); 
        }
    }

    // Todo: Implement exception handling for negative deposits
    public void deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new NegativeDepositException("Deposit amount cannot be negative."); // Prevents negative deposits
        }
        balance += amount;
        notifyObservers("Deposit: $" + amount); 
    }

    // Todo: Implement exception handling for overdrawing and closed accounts
    public void withdraw(double amount) throws Exception {
        if (!isActive) {
            throw new InvalidAccountOperationException("Cannot withdraw from a closed account."); // Prevents withdrawal from closed accounts
        }
        if (amount > balance) {
            throw new OverdrawException("Insufficient funds. Cannot withdraw $" + amount); // Prevents overdrawing
        }
        if (amount < 0) {
            throw new NegativeDepositException("You cannot withdraw a negative amount of money"); // Prevents negative withdraws
        }
        balance -= amount;
        notifyObservers("Withdraw: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
    
    // Todo: Prevent further transactions when the account is closed
    public void closeAccount() {
        isActive = false;
        notifyObservers("Account has been closed."); 
    }
}