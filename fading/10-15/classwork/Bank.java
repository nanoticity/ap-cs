public class Bank {
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Bank(String n, double b, int p) {
        name = n;
        balance = b;
        pin = p;
        access = false;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(int inputPin) {
        access = (inputPin == pin);
        return access;
    }

    public void deposit(double amount) {
        if (access) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (access && amount <= balance) {
            balance -= amount;
        }
    }

    public void logout() {
        access = false;
    }
}
