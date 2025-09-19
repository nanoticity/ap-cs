import java.util.Scanner;

public class AreaQuiz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a choice:");
        System.out.println("1 - Area of a Triangle Quiz");
        System.out.println("2 - Area of a Square Quiz");
        System.out.println("3 - Area of a Rectangle Quiz");
        System.out.println("4 - Pythagorean Theorem Quiz");
        System.out.println("5 - Circumference of a Circle Quiz");
        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.print("If the base is 10.0 and height is 5.0, what is the Area of a Triangle? ");
            double answer = scan.nextDouble();
            if (answer == 25.0) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is 25.0");
            }

            scan.nextLine();

        } else if (choice == 2) {
            System.out.print("If the side is 10.0, what is the Area of a Square? ");
            double answer = scan.nextDouble();
            if (answer == 100.0) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is 100.0");
            }

            scan.nextLine();

        } else if (choice == 3) {
            System.out.print("If the length is 5.0 and height is 4.0, what is the Area of a Rectangle? ");
            double answer = scan.nextDouble();
            if (answer == 20.0) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is 20.0");
            }

            scan.nextLine();

        } else if (choice == 4) {
            System.out.print("If a is 3.0 and b is 4.0, what is c in terms of the Pythagorean Theorem? ");
            double answer = scan.nextDouble();
            if (answer == 5.0) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is 5.0");
            }
            scan.nextLine();

        } else if (choice == 5) {
            System.out.print("If the radius is 0.5, what is the circumference of a circle? ");
            double answer = scan.nextDouble();
            double correct = 0.5 * Math.PI * 2; // 2πr
            if (answer == correct) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct);
            }

            scan.nextLine();

        } else {
            System.out.println("Invalid choice.");
        }

        scan.close();
    }
}
