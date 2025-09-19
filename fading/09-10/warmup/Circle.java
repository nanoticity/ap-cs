import java.util.Scanner;

public class Circle {

    public void printCircumference() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the radius for a circle: ");
        int radius = scan.nextInt();
        double circumference = 2 * 3.14 * radius;
        System.out.println("The circumference of a circle with radius " + radius + " is: " + circumference);
    }

    public void printArea() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the radius for a circle: ");
        int radius = scan.nextInt();
        double area = 3.14 * Math.pow(radius, 2);
        System.out.println("The area of a circle with radius " + radius + " is: " + area);
    }

}
