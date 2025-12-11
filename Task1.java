class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void applyInterest() {
        balance += balance * (interestRate / 100);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("BA101", "Ravi", 5000);
        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.printDetails();

        System.out.println();

        SavingsAccount sav1 = new SavingsAccount("SA202", "Sohneyo", 8000, 5);
        sav1.deposit(2000);
        sav1.withdraw(3000);
        sav1.applyInterest();
        sav1.printDetails();
    }
}
