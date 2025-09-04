import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a choice:");
            System.out.println("1 - Math Quiz");
            System.out.println("2 - History Quiz");
            System.out.println("3 - Art Quiz");
            int choice = scan.nextInt();

            if (choice == 1) {

                
                System.out.print("If the base is 10.0 and height is 5.0, what is the Area of a Triangle? ");
                double answer1 = scan.nextDouble();
                if (answer1 == 25.0) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is 25.0");
                }

                scan.nextLine();

            
                System.out.print("If the side is 10.0, what is the Area of a Square? ");
                double answer2 = scan.nextDouble();
                if (answer2 == 100.0) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is 100.0");
                }

                scan.nextLine();

                
                System.out.print("If the length is 5.0 and height is 4.0, what is the Area of a Rectangle? ");
                double answer3 = scan.nextDouble();
                if (answer3 == 20.0) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is 20.0");
                }

                scan.nextLine();
            } else if (choice == 2) {
                System.out.println("Starting History Quiz...");
                System.out.println("When was the declaration of independence signed? ");
                scan.nextLine();
                String text = scan.nextLine();
                if (text.equals("July 4, 1776")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is July 4, 1776");   
                }
                System.out.println("What was the name of the peace treaty that officially ended World War I? ");
                // scan.nextLine();
                String answer = scan.next();
                if (answer.equals("Treaty of Versailles")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is Treaty of Versailles.");   
                }

                System.out.println("What event is considered the start of World War II in Europe? ");
                scan.nextLine();
                String answer1 = scan.nextLine();
                if (answer1.equals("The invasion of Poland by Nazi Germany on September 1, 1939.")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is The invasion of Poland by Nazi Germany on September 1, 1939.");   
                }
            } else if (choice == 3) {
                System.out.println("Starting Art Quiz...");
                String cat = "/\\_/\\\n"
           + "( o.o )\n"
           + " > ^ <\n";

                String fish = "><(((('> ";

                String bird = "   \\ \\ \n"
            + "   (o>\n"
            + "\\\\_//)\n"
            + " \\_/_)\n"
            + "  _|_   \n";
                
                System.out.println("What is this animal?\n" + cat);
                scan.nextLine();
                String animal1 = scan.nextLine();
                if (animal1.equals("cat")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is cat");   
                }
                System.out.println("What is this animal?\n" + fish);
                String animal2 = scan.nextLine();
                if (animal2.equals("fish")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is fish");
                }
                System.out.println("What is this animal?\n" + bird);
                String animal3 = scan.nextLine();
                if (animal3.equals("bird")) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is bird");
                }
                
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}   