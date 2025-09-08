import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the radius of the cylinder: ");
        double radius = scan.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double height = scan.nextDouble();
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume);

        System.out.println("What state is the Grand Canyon located?");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("Arizona")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is Arizona.");
        }
    }
}