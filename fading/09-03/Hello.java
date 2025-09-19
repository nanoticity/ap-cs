import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scan.next();

        System.out.println("Hello, " + firstName);
        scan.nextLine();

        System.out.print("Enter your full name: ");
        String fullName = scan.nextLine();

        System.out.println("Hello, " + fullName);
    }
}