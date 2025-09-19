import java.util.Scanner;

public class Age {

    // Method to calculate age
    public static int calculateAge(int birthYear) {
        return 2025 - birthYear;
    }

    // Method to check months
    public static int checkMonths( int age, int birthMonth) {
        if (birthMonth > 8) {
            return age - 1;
        }
        return age;
    }

    public static void main( String[] args) {
        int birthMonth, birthYear;
        Scanner scan = new Scanner(System.in);

        System.out.println("Age Calculator");

        System.out.println("Enter your birth year as a 4 digit number (e.g. 2011):");
        birthYear = scan.nextInt();

        System.out.println("Enter your birth month as a 1 or 2 digit number (e.g. '5' for may):");
        birthMonth = scan.nextInt();

        int age = checkMonths(calculateAge(birthYear), birthMonth);
        System.out.println("Your age is " + age);
    }
}