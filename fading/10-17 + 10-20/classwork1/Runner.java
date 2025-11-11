import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= 12; i++) {
            System.out.println(i);
        }
        System.out.println();







        for (int i = 5; i <= 31; i++) {
            System.out.println(i);
        }
        System.out.println();






        for (int i = 39; i >= 21; i--) {
            System.out.println(i);
        }
        System.out.println();






        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
        System.out.println();





        for (int i = 15; i >= -10; i -= 5) {
            System.out.println(i);
        }
        System.out.println();





        int nGreaterThan1;
        while (true) {
            System.out.print("Enter a number greater than 1: ");
            if (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next(); // consume invalid token
                continue;
            }
            nGreaterThan1 = in.nextInt();
            if (nGreaterThan1 > 1) break;
            System.out.println("Number must be greater than 1.");
        }
        for (int i = 1; i <= nGreaterThan1; i++) {
            System.out.println(i);
        }
        System.out.println();





        int lessThan10;
        while (true) {
            System.out.print("Enter a number less than 10: ");
            if (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next();
                continue;
            }
            lessThan10 = in.nextInt();
            if (lessThan10 < 10) break;
            System.out.println("Number must be less than 10.");
        }
        for (int i = 50; i >= lessThan10; i--) {
            System.out.println(i);
        }
        System.out.println();




        int targetGreater20;
        while (true) {
            System.out.print("Enter a number greater than 20: ");
            if (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next();
                continue;
            }
            targetGreater20 = in.nextInt();
            if (targetGreater20 > 20) break;
            System.out.println("Number must be greater than 20.");
        }


        

        int step;
        while (true) {
            System.out.print("Enter the step (positive integer to count by): ");
            if (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next();
                continue;
            }
            step = in.nextInt();
            if (step > 0) break;
            System.out.println("Step must be a positive integer.");
        }

        for (int i = 0; i <= targetGreater20; i += step) {
            System.out.println(i);
        }
        System.out.println();




        int sumTarget;
        while (true) {
            System.out.print("Enter a number greater than 1 to sum 1..n: ");
            if (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next();
                continue;
            }
            sumTarget = in.nextInt();
            if (sumTarget > 1) break;
            System.out.println("Number must be greater than 1.");
        }

        int sum = ((int) sumTarget * (sumTarget + 1)) / 2;
        System.out.println("Summation 1.." + sumTarget + " = " + sum);


        in.close();
    }
}