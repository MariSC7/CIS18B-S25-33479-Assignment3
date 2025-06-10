import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double initialBalance;

            // Todo: Ask the user to enter an initial balance and create a BankAccount object
            System.out.print("Enter initial balance: ");
            initialBalance = scanner.nextDouble();
            
            //Checks for negative initial balance and string input. 
            while (initialBalance < 0){
                try {
                    System.out.println ("\nError: Enter a positive value");
                    System.out.print("Enter initial balance: ");   
                    initialBalance = scanner.nextDouble();     
                } catch (InputMismatchException StringInput) {
                    System.out.println ("\nError: Enter a valid number");
                    initialBalance = scanner.nextDouble();
                }
            }

            BankAccount account = new BankAccount("123456", initialBalance);
            System.out.println("Bank Account Created: #123456");

            // Todo: Create a TransactionLogger and attach it to the account
            TransactionLogger logger = new TransactionLogger();
            account.addObserver(logger);

            // Todo: Wrap account in SecureBankAccount decorator
            SecureBankAccount secureAccount = new SecureBankAccount(account);

            // Todo: Allow the user to enter deposit and withdrawal amounts
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            secureAccount.deposit(depositAmount); // Deposit money into the account

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            secureAccount.withdraw(withdrawalAmount); // Withdraw money from the account

            // To do: Display the final balance
            System.out.println("Final Balance: $" + secureAccount.getBalance());
            
        // Todo: catch and Handle specific exceptions and display the corresponding error message.
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); 
        } finally {
            scanner.close(); 
        }
    }
}
