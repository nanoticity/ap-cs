import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Selection selection = new Selection();

        System.out.print("Enter a score: ");
        int score = scanner.nextInt();
        System.out.println("Grade: " + selection.gradeCalculator(score));
        while (true) {
            System.out.println("Possible zip codes:");
            System.out.println("94040, 94115, 95051, 95129, 94607, 95035, 0 to quit");


            System.out.print("Enter a zip code: ");
            int zip = scanner.nextInt();
            if (zip == 0) {
                System.out.println("Exiting.");
                scanner.close();
                break;
            } else {
                System.out.println("Location: " + selection.zipCode1(zip));
                System.out.println("Location (switch): " + selection.zipCode2(zip));
            }
        }

        scanner.close();
    }
}
