import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Bank myAccount = new Bank(name, balance);
        System.out.println("Account created for " + myAccount.getName() + " with balance $" + myAccount.getBalance());


        while (true) {
            System.out.print("Menu:\n1. Deposit\n2. Withdraw\nChoose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    System.out.println("New balance: $" + myAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawalAmount);
                    System.out.println("New balance: $" + myAccount.getBalance());
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
